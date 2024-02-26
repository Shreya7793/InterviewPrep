import java.util.*;

public class TestPlayGround {
    interface Itest{
        int a=0;
        final int var=0;
        static int varstatic=0;

        private void testmethod(){

        }
    }
    abstract class testabstract{
        int a;
        final int var=0;
        static int varstatic=0;
        testabstract(){

        };
        final public  void testmethodfinal(){

        }

        public  void testmethod(){

        }
        public  abstract void testmethodabstracyt();
    }
    class testConcrete extends  testabstract{

        @Override
        public void testmethodabstracyt() {
            try{
                int i=10/0;
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }

    }
    class testInterface implements Itest{

    }
    testabstract test=new testConcrete();
    Itest testObj = new Itest() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };
    static int trycatch(){
        try{
            int i=10/0;
            return i;
        }
        catch (ArithmeticException e){
            return -1;
        }
        finally {
            return 0;
        }
    }
    public  static void main(String [] args){

        System.out.println("try-catch="+trycatch());
        List<Integer> list=new ArrayList<>();
        list.add(null);
        List<Integer> linkedList= new LinkedList<>();
        linkedList.add(null);
        List<Integer> vector = new Vector<>();
        vector.add(null);
        List<Integer> stack = new Stack<>();
        stack.add(null);
        Queue<Integer> queue=new PriorityQueue<>();
        queue.offer(1);
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(null);
        Set<Integer> set= new TreeSet<>();
        set.add(9);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
        System.out.println(set);
        Map<Integer,Integer> map=new HashMap<>();
        map.put(null,null);
        map.put(null,1);
        map.put(null,2);
        Collections.sort(list);
        System.out.println(map.get(null));
    }
}
