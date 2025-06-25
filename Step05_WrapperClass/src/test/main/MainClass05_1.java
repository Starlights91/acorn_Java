/**
 * 
 */
package test.main;

import java.util.*;
/**
 * 
 */
public class MainClass05_1 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] symbols = {"🍒", "🍎", "🍌", "🍈", "7"};
        int coin = 1000;
        int playCost = 100;
        int jackpotMultiplier = 10;

        System.out.println("🎰 슬롯머신 게임 시작!");
        System.out.println("보유 코인: " + coin + "원");

        while (coin >= playCost) {
            System.out.print("\n▶️ 엔터를 눌러 플레이 (현재 코인: " + coin + "원): ");
            input.nextLine(); // 엔터 대기

            // 코인 차감
            coin -= playCost;

            // 슬롯 결과 뽑기
            String r1 = symbols[random.nextInt(symbols.length)];
            String r2 = symbols[random.nextInt(symbols.length)];
            String r3 = symbols[random.nextInt(symbols.length)];

            System.out.println("🎲 결과: " + r1 + " | " + r2 + " | " + r3);

            // 잭팟 판단
            Set<String> resultSet = new HashSet<>();
            resultSet.add(r1);
            resultSet.add(r2);
            resultSet.add(r3);

            if (resultSet.size() == 1) {
                int reward = playCost * jackpotMultiplier;
                coin += reward;
                System.out.println("🎉 잭팟!! " + reward + "원 획득!");
            } else {
                System.out.println("🙁 꽝! 다시 도전!");
            }
        }

        System.out.println("\n💀 코인이 모두 소진되었습니다. 게임 종료.");
    }
}
