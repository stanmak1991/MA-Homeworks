package Homework09;

import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    private Map<String, List<T>> mailBox = new MapCustom<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> mailMessage) {
        String key = mailMessage.getTo();
        List<T> contents = mailBox.containsKey(key) == true ? mailBox.get(key) : new LinkedList<>();
        contents.add(mailMessage.getContent());
        mailBox.put(key, contents);
    }
}