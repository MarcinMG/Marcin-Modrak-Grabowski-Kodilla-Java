package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumList= new ArrayList<>();

    public Forum() {
        theForumList.add(new ForumUser("001", "Marcin", 'M', 1985, 1,1, 55 ));
        theForumList.add(new ForumUser("002", "Joanna", 'K', 1990, 2,2 , 2 ));
        theForumList.add(new ForumUser("003", "Marek", 'M', 1997, 12,31, 15 ));
        theForumList.add(new ForumUser("004", "Paweł", 'M', 1995, 4,4, 0 ));
        theForumList.add(new ForumUser("005", "Rafał", 'M', 1975, 5,5, 1 ));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumList);
    }
}
