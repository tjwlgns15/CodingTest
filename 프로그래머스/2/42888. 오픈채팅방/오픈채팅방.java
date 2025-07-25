import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, User> users = new HashMap<>();
        List<Action> actions = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            String uid = split[1];

            if (action.equals("Enter")) {
                String name = split[2];
                users.put(uid, new User(uid, name));
                actions.add(new Action(uid, Action.ActionType.ENTER));
            } else if (action.equals("Leave")) {
                actions.add(new Action(uid, Action.ActionType.LEAVE));
            } else if (action.equals("Change")) {
                String name = split[2];
                users.put(uid, new User(uid, name));
            }
        }

        String[] answer = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            User user = users.get(action.getUid());
            
            if (action.getActionType() == Action.ActionType.ENTER) {
                answer[i] = user.getName() + "님이 들어왔습니다.";
            } else {
                answer[i] = user.getName() + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

class User {
    private final String uid;
    private final String name;

    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Action {
    private final String uid;
    private final ActionType actionType;

    static enum ActionType {
        ENTER,
        LEAVE,
    }

    public Action(String uid, ActionType actionType) {
        this.uid = uid;
        this.actionType = actionType;
    }

    public String getUid() {
        return uid;
    }

    public ActionType getActionType() {
        return actionType;
    }
}