import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        TaskScheduler scheduler = new TaskScheduler();
        return scheduler.scheduleTasks(plans);
    }
}

class TaskScheduler {
    private Stack<Task> pausedTasks = new Stack<>();
    private List<String> completedTasks = new ArrayList<>();
    private TimeConverter timeConverter = new TimeConverter();

    public String[] scheduleTasks(String[][] plans) {
        List<Task> tasks = parseAndSortTasks(plans);

        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            int nextTaskStartTime = (i + 1 < tasks.size()) ? tasks.get(i + 1).getStartTime() : Integer.MAX_VALUE;

            processCurrentTask(currentTask, nextTaskStartTime);
        }

        completeRemainingTasks();

        return completedTasks.toArray(new String[0]);
    }

    private List<Task> parseAndSortTasks(String[][] plans) {
        List<Task> tasks = new ArrayList<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int startTime = timeConverter.timeToMinutes(plan[1]);
            int duration = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, startTime, duration));
        }

        tasks.sort(Comparator.comparingInt(Task::getStartTime));
        return tasks;
    }

    private void processCurrentTask(Task currentTask, int nextTaskStartTime) {
        int currentTime = currentTask.getStartTime();

        currentTime = processPausedTasksBeforeNewTask(currentTime);

        currentTime = Math.max(currentTime, currentTask.getStartTime());

        int taskEndTime = currentTime + currentTask.getRemainingTime();

        if (taskEndTime <= nextTaskStartTime) {
            completedTasks.add(currentTask.getName());
            currentTime = taskEndTime;

            processPausedTasksAfterCompletion(currentTime, nextTaskStartTime);
        } else {
            int workedTime = nextTaskStartTime - currentTime;
            currentTask.reduceRemainingTime(workedTime);
            pausedTasks.push(currentTask);
        }
    }

    private int processPausedTasksBeforeNewTask(int currentTime) {
        return currentTime;
    }

    private void processPausedTasksAfterCompletion(int currentTime, int nextTaskStartTime) {
        while (!pausedTasks.isEmpty() && currentTime < nextTaskStartTime) {
            Task pausedTask = pausedTasks.pop();
            int availableTime = nextTaskStartTime - currentTime;

            if (pausedTask.getRemainingTime() <= availableTime) {
                completedTasks.add(pausedTask.getName());
                currentTime += pausedTask.getRemainingTime();
            } else {
                pausedTask.reduceRemainingTime(availableTime);
                pausedTasks.push(pausedTask);
                break;
            }
        }
    }

    private void completeRemainingTasks() {
        while (!pausedTasks.isEmpty()) {
            completedTasks.add(pausedTasks.pop().getName());
        }
    }
}

class Task {
    private final String name;
    private final int startTime;
    private int remainingTime;

    public Task(String name, int startTime, int duration) {
        this.name = name;
        this.startTime = startTime;
        this.remainingTime = duration;
    }

    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void reduceRemainingTime(int time) {
        this.remainingTime -= time;
    }
}

class TimeConverter {
    public int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}