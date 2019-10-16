    package com.nbu.sportapp.nbusportapp.repository;

    import com.nbu.sportapp.nbusportapp.entity.account.Account;
    import com.nbu.sportapp.nbusportapp.repository.AccountRepository;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
    import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
    import org.springframework.test.context.junit4.SpringRunner;

    import java.util.ArrayList;
    import java.util.List;

    import static org.assertj.core.api.Java6Assertions.assertThat;

    @RunWith(SpringRunner.class)
    @DataJpaTest
    public class AccountRepositoryIntegrationTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private AccountRepository accountRepository;

        @Test
        public void testSaveAccount(){
            Account user = new Account("Ivan Stanev","zirow000@abv.bg","1234567");
            Account saveInDb = this.entityManager.persist(user);
            Account getFromDb = this.accountRepository.findOne(saveInDb.getId());

            assertThat(getFromDb).isEqualTo(saveInDb);
        }

        @Test
        public void testGetAccountById(){
            Account account = new Account("Ivan Stanev","zirow000@abv.bg","1234567");

            //Save account in DB
            Account accountSavedInDb = entityManager.persist(account);

            //Get account from DB
            Account accountFromInDb = this.accountRepository.findOne(accountSavedInDb.getId());
            assertThat(accountSavedInDb).isEqualTo(accountFromInDb);
        }

        @Test
        public void testGetAllAccounts(){
            Account account1 = new Account("Ivan Stanev","zirow000@abv.bg","1234567");


            Account account2 = new Account("Peter Stanev","asasasas@abv.bg","11234567");


            //Save both accounts in DB
            entityManager.persist(account1);
            entityManager.persist(account2);

            Iterable<Account> allAccountsFromDb = this.accountRepository.findAll();
            List<Account> accountList = new ArrayList<>();

            for (Account account: allAccountsFromDb) {
                accountList.add(account);
            }
            assertThat(accountList.size()).isEqualTo(2);
        }


        @Test
        public void testFindByEmail(){
            Account account = new Account("Ivan Stanev","zirow000@abv.bg","1234567");


            //Account in DB
            entityManager.persist(account);

            //Get ticket info from DB for specified email
            Account getFromDb = this.accountRepository.findByEmail("zirow000@abv.bg");
            assertThat(getFromDb.getFullName()).isEqualTo("Ivan Stanev");
        }

        @Test
        public void testDeleteAccountById(){
            Account account1 = new Account("Ivan Stanev","zirow000@abv.bg","1234567");


            Account account2 = new Account("Peter Stanev","asasasas@abv.bg","11234567");

            //Save both accounts in DB
            Account persist = entityManager.persist(account1);
            entityManager.persist(account2);

            //delete one account DB
            entityManager.remove(persist);

            Iterable<Account> allAccountsFromDb = this.accountRepository.findAll();
            List<Account> accountList = new ArrayList<>();

            for (Account account: allAccountsFromDb) {
                accountList.add(account);
            }
            assertThat(accountList.size()).isEqualTo(1);
        }

        @Test
        public void testUpdateAccount(){
            Account account = new Account("Ivan Stanev","zirow000@abv.bg","1234567");


            //save Account info in DB
            entityManager.persist(account);

            Account getFromDb = this.accountRepository.findByEmail("zirow000@abv.bg");
            //update Email Address
            getFromDb.setEmail("gavazov99@gmail.com");
            entityManager.persist(getFromDb);

            assertThat(getFromDb.getEmail()).isEqualTo("gavazov99@gmail.com");
        }
    }
