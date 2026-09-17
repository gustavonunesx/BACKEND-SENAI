package br.com.aweb.sistama_produto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPF, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }

        String cpf = value.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }

        int[] digits = cpf.chars().map(c -> c - '0').toArray();

        int firstCheckDigit = calculateCheckDigit(digits, 9, 10);
        if (firstCheckDigit != digits[9]) {
            return false;
        }

        int secondCheckDigit = calculateCheckDigit(digits, 10, 11);
        return secondCheckDigit == digits[10];
    }

    private int calculateCheckDigit(int[] digits, int length, int initialWeight) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += digits[i] * (initialWeight - i);
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}
