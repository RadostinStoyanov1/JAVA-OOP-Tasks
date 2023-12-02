import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private Map<Integer, Transaction> database;

    public ChainblockImpl() {
        this.database = new LinkedHashMap<>();
    }

    public int getCount() {
        return database.size();
    }

    public void add(Transaction transaction) {
        database.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return database.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return database.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        Transaction transaction = getById(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        Transaction transaction = getById(id);
        database.remove(transaction.getId());
    }

    public Transaction getById(int id) {
        if (!database.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return database.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = database.values().stream().filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactionList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Map<String, List<Transaction>> senders = database.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.groupingBy(Transaction::getFrom));

        if (senders.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Map<String, List<Transaction>> sendersSorted = new LinkedHashMap<>();

        senders.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEachOrdered(x -> sendersSorted.put(x.getKey(), x.getValue()));

        List<String> result = new ArrayList<>();

        sendersSorted.entrySet().forEach(x -> {
            for (int i = 0; i < x.getValue().size(); i++) {
                result.add(x.getKey());
            }
        });
        return result;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
