import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void test(){
        StudentArrayDeque<Integer> studentDq = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> dq = new ArrayDequeSolution<>();
        String logMssg = "";

        for(int i = 0; i < 1000; i++){
            int randomN = StdRandom.uniform(4);
            switch (randomN){
                case 0:
                    studentDq.addFirst(i);
                    dq.addFirst(i);
                    logMssg = logMssg + "addFirst(" + i + ")\n";
                    break;
                case 1:
                    studentDq.addLast(i);
                    dq.addLast(i);
                    logMssg = logMssg + "addLast(" + i + ")\n";
                    break;
                case 2:
                    if(!studentDq.isEmpty() && !dq.isEmpty()) {
                        studentDq.removeFirst();
                        dq.removeFirst();
                        logMssg = logMssg + "removeFirst()\n";
                    }
                    break;
                case 3:
                    if(!studentDq.isEmpty() && dq.isEmpty()) {
                        studentDq.removeLast();
                        dq.removeLast();
                        logMssg = logMssg + "removeLast()\n";
                    }
                    break;
            }
            if(i % 10 == 0) {
                if (!studentDq.isEmpty() && !dq.isEmpty())
                    logMssg = logMssg + "removeFirst()\n";
                    assertEquals(logMssg, studentDq.removeFirst(), dq.removeFirst());
            }

        }

    }
}
