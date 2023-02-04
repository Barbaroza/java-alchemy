package com.pmb.wait;

public class GetBillInfo {
    public static void getBillInfo(Double loanAmount, Integer months, Integer Prepayment, Double interestRate) {
        Double monthInterestRate = interestRate / 12;
        Double dengxiPerMonth = loanAmount * (monthInterestRate * Math.pow(1 + monthInterestRate, months)) / (Math.pow(1 + monthInterestRate, months) - 1);
        Double dengePerMonth = loanAmount / months;

        System.out.println(dengxiPerMonth);
        Double payTotaldengxi = loanAmount;
        Double payTotaldengjin = loanAmount;
        Double hasPay = 0d;
        for (int i = 1; i <= months; i++) {
            if (i == Prepayment) {
                double a = payTotaldengxi + (i - 1) * dengxiPerMonth;
                double b = payTotaldengjin + hasPay;

                System.out.println("等额本息" + i + "期" + "|当月还款:" + payTotaldengxi + "|" + "|已还款:" + a);
                System.out.println("等额本金" + i + "期" + "|当月还款:" + payTotaldengjin + "|" + "|已还款:" + b);

                break;
            }
            double denngxi = dengxiPerMonth - payTotaldengxi * monthInterestRate;
            payTotaldengxi -= denngxi;
            double denge = payTotaldengjin * monthInterestRate;
            payTotaldengjin -= dengePerMonth;
            double dengeCurrentMonth = denge + dengePerMonth;
            hasPay += dengeCurrentMonth;
            System.out.println("等额本息" + i + "期" + "|当月还款:" + dengxiPerMonth + "|" + "|已还款:" + i * dengxiPerMonth + "|剩余本金:" + payTotaldengxi);
            System.out.println("等额本金" + i + "期" + "|当月还款:" + dengeCurrentMonth + "|" + "|已还款:" + hasPay + "|剩余本金:" + payTotaldengjin);
        }
        System.out.println("贷款总额:" + loanAmount + "|年利率:" + interestRate + "|总期数" + months + "|截止期数:" + Prepayment);
    }

    public static void main(String[] args) {
        GetBillInfo.getBillInfo(530000d, 300, 300, 0.04d);
    }
}
