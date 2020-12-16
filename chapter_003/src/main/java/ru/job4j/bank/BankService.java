package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (findByPassport(user.getPassport()) == null) {
            this.users.putIfAbsent(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!this.users.get(user).contains(account)) {
                this.users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return this.users.keySet().stream().filter(u -> u.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return this.users.get(user).stream().filter(a -> a.getRequisite().equals(requisite))
                    .findFirst().orElse(null );
        }
        return null;

    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        if (accSrc == null || accSrc.getBalance() < amount) {
            return false;
        }
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accDest != null) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDest.setBalance(accDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}