package com.example.java_development.module3;

import java.util.ArrayList;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    Story() {
        ArrayList<Situation> situations = new ArrayList<Situation>();
        // 0 done
        situations.add(new Situation("Первая задача))",
                "Вам дали задачу: оптимально написать решение задачи, но вы не знаете, как это сделать\n" +
                        "(1)написать программу неоптимально\n" +
                        "(2)целый день искать решение, показать себя с хорошей стороны\n" +
                        "(3)перенести дедлайн на следующий день",
                new int[]{1, 2, 3}, 0, 0, 0
        ));
        // 1 done
        situations.add(new Situation("Обман руководства",
                "Вы написали программу ужасно, но ваша ложь была обнаружена\n" +
                        "(1)извиниться, попросить начальство попытку переделать\n" +
                        "(2)поругаться с вышестоящими и уйти с работы\n" +
                        "(3)попросить другую задачу",
                new int[]{0, 4, 5}, 0, 0, -10
        ));
        // 2 done
        situations.add(new Situation("Успех.",
                "С помощью middle'а вы решили задачу, за что ему очень благодарны\n" +
                        "(1)поблагодарить сотрудника за помощь\n" +
                        "(2)осознать, что сам ничего не можешь, и упасть в депрессию\n" +
                        "(3)просить премию у руководства",
                new int[]{6, 7, 8}, 1, 10, 10
        ));
        // 3 done
        situations.add(new Situation("Задержка зарплаты",
                "Вам сделали выговор, зарплата задерживается\n" +
                        "(1)поругаться с вышестоящими и уйти с работы\n" +
                        "(2)попросить другую задачу\n",
                new int[]{4, 5}, 0, -10, 0
        ));
        // 4 done
        situations.add(new Situation("Увольнение",
                "Вы были уволены за плохую работу",
                new int[]{}, -3, 0, -50
        ));
        // 5 done
        situations.add(new Situation("Вам пошли навстречу",
                "Вторая задача кажется вам более лёгкой\n" +
                        "(1)начать делать новую задачу\n" +
                        "(2)пойти отдыхать\n" +
                        "(3)решить задачу плохо",
                new int[]{9, 10, 11}, 0, 0, 10
        ));
        // 6 done
        situations.add(new Situation("С вас требуют денег((",
                "Разработчик просит вас заплатить ему\n" +
                        "(1)отдать запрошенную сумму\n" +
                        "(2)пожаловаться начальству\n",
                new int[]{12, 4}, 0, 0, 0
        ));
        // 7 done
        situations.add(new Situation("Удалёнка",
                "Вас отправили на дистанционную работу и дали сложную задачу, которую вы не можете решить\n" +
                        "(1)купить решение\n" +
                        "(2)поругаться с вышестоящими и уйти с работы\n",
                new int[]{13, 4}, 0, 0, 0
        ));
        // 8 done
        situations.add(new Situation("Щедрое \"правительство\"",
                "Вас поставили перед выбором\n" +
                        "(1)премия\n" +
                        "(2)работа\n",
                new int[]{14, 15}, 0, 0, -10
        ));
        // 9 done
        situations.add(new Situation("Решение",
                "Вы написали программу, это было просто\n" +
                        "(1)Промолчать\n" +
                        "(2)Похвастаться\n",
                new int[]{16, 15}, 1, 1, 10
        ));
        // 10 done
        situations.add(new Situation("Долгий отдых",
                "Вас уволили за просрочивание дедлайна",
                new int[]{}, -3, 0, -10
        ));
        // 11 done
        situations.add(new Situation("Злой дядя",
                "Директор оказался недоволен вашей работой. До свидания",
                new int[]{}, -1, 0, -10
        ));
        // 12 done
        situations.add(new Situation("Увольнение...",
                "Вас всё равно уволили с работы за плохую работу, но вы ещё и потеряли деньги\n",
                new int[]{}, 0, -50, 0
        ));
        // 13 done
        situations.add(new Situation("Каникулы",
                "Вам сказали спасибо за работу, но денег больше нет.. Каникулы!!!\n",
                new int[]{}, 1, -50, 0
        ));
        // 14 done
        situations.add(new Situation("Премия",
                "Вам выдали премию и, ожидаемо, уволили\n",
                new int[]{}, -3, 100, 0
        ));
        // 15 done
        situations.add(new Situation("Каникулы..",
                "Вас отправили на каникулы, но начальство было не очень довольно\n",
                new int[]{}, 0, 0, 0
        ));
        // 16 done
        situations.add(new Situation("Хороший отпуск",
                "Начальство выдало вам премию, было довольно вами.\n",
                new int[]{}, 0, 0, 20
        ));
        for (Situation s :
                situations) {
            for (int i = 0; i < s.direction.length; i++) {
                s.direction[i] = situations.get(s.directionIndexes[i]);
            }
        }
        current_situation = situations.get(0);
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из " + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
