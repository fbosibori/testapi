package com.kcbgroup.testapi.Repo;

import com.kcbgroup.testapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
