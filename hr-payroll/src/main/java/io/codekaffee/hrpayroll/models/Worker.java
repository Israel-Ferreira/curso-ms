package io.codekaffee.hrpayroll.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Worker {
    private String name;
    private Double dailyIncome;
}
