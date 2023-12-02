import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private ChainblockImpl database;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        database = new ChainblockImpl();
        transactions = createTransactions();
    }

    @Test
    public void test_GetCount_ShouldReturn_CorrectCount() {
        fillDatabase();
        assertEquals(transactions.size(), database.getCount());
    }

    @Test
    public void test_GetCount_EmptyDB_ShouldReturn_Zero() {
        database = new ChainblockImpl();
        assertEquals(0, database.getCount());
    }

    @Test
    public void test_AddTransactionSuccessfully() {
        Transaction expectedTransaction = transactions.get(0);
        database.add(expectedTransaction);

        Transaction actualTransaction = database.getById(expectedTransaction.getId());
        assertEquals(expectedTransaction, actualTransaction);
        assertEquals(1, database.getCount());
    }

    @Test
    public void test_AddDuplicatedTransaction_ShouldNotAdd() {
        Transaction transaction = transactions.get(0);
        database.add(transaction);
        database.add(transaction);

        assertEquals(1, database.getCount());
    }

    @Test
    public void test_Contains_TransactionExists() {
        Transaction transaction = transactions.get(0);
        Transaction transaction1 = transactions.get(1);
        database.add(transaction);

        assertTrue(database.contains(transaction));
        assertTrue(database.contains(transaction.getId()));
    }

    @Test
    public void test_Contains_TransactionNotPresent() {
        Transaction transaction = transactions.get(0);
        Transaction transaction1 = transactions.get(1);
        database.add(transaction);

        assertFalse(database.contains(transaction1));
        assertFalse(database.contains(transaction1.getId()));
    }

    @Test
    public void test_Change_TransactionStatus_When_TransactionExists() {
        fillDatabase();
        database.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
        assertEquals(TransactionStatus.SUCCESSFUL, database.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Change_TransactionStatus_ShouldThrow_WhenTransactionNotExist() {
        fillDatabase();
        database.changeTransactionStatus(100, TransactionStatus.FAILED);
    }

    @Test
    public void test_RemoveTransaction_Successfully() {
        fillDatabase();
        database.removeTransactionById(1);
        assertEquals(4, database.getCount());
        assertFalse(database.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransaction_ShouldRemove_CorrectTransaction() {
        fillDatabase();
        database.removeTransactionById(100);
    }

    @Test
    public void test_GetById_ShouldReturn_CorrectTransaction() {
        fillDatabase();
        Transaction actualTransaction = database.getById(1);
        assertEquals(1, actualTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_ShouldThrow_WhenSuchTransaction_NotPresent() {
        fillDatabase();
        database.getById(100);
    }

    @Test
    public void test_GetByTransactionStatus_ReturnsList_WithCorrectTransactions() {
        fillDatabase();
        List<Transaction> result = new ArrayList<>();
        database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED)
                .forEach(result::add);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getStatus(), TransactionStatus.UNAUTHORIZED);
        }

        Transaction transaction1 = result.get(0);
        Transaction transaction2 = result.get(1);

        assertEquals(1, transaction1.getId());
        assertEquals(5, transaction2.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_ThrowsWhen_NoTransactions() {
        fillDatabase();
        database.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void test_GetALlSenders_WithTransactionStatus_TransactionsExist() {
        fillDatabase();
        Transaction transaction6 = new TransactionImpl(6, TransactionStatus.UNAUTHORIZED, "Ivan", "John", 10.56);
        database.add(transaction6);
        List<String> sendersList = new ArrayList<>();
        database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED).forEach(sendersList::add);
        String sender1 = sendersList.get(0);
        String sender2 = sendersList.get(1);
        String sender3 = sendersList.get(2);

        assertEquals("Ivan", sender1);
        assertEquals("Ivan", sender2);
        assertEquals("Kaloyan", sender3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetALlSenders_WithTransactionStatus_TransactionsNotExist() {
        fillDatabase();
        database.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    /*Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status);

    Iterable<Transaction> getAllOrderedByAmountDescendingThenById();

    Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender);

    Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver);

    Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount);

    Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount);

    Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi);

    Iterable<Transaction> getAllInAmountRange(double lo, double hi);*/

    private List<Transaction> createTransactions() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.UNAUTHORIZED, "Ivan", "Kaloyan", 67.89);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.FAILED, "Peter", "Sofia", 100.89);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "John", "Ann", 55.55);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Stoyan", "Martin", 78.00);
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, "Kaloyan", "John", 10.56);

        List<Transaction> transactionsList = new ArrayList<>();
        transactionsList.add(transaction1);
        transactionsList.add(transaction2);
        transactionsList.add(transaction3);
        transactionsList.add(transaction4);
        transactionsList.add(transaction5);

        return transactionsList;
    }

    private void fillDatabase() {
        createTransactions().forEach(t -> database.add(t));
    }


}
