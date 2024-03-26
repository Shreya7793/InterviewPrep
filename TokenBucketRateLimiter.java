import java.util.ArrayList;
import java.util.List;

public class TokenBucketRateLimiter {
    public static boolean isAllowed(int bucketSize,Object token){
        List<Object> bucketList=new ArrayList<>();
        int currentBucketSize= bucketList.size();
        if(currentBucketSize<bucketSize){
            bucketList.add(token);
            return true;
        }
        else
            return false;
    }
    public static void main(String []args){
        int bucketSize=10;
        System.out.println("Test ratelimit req"+isAllowed(bucketSize, "test tokenn"));
    }

}

/*
Events: A B C X Y Z
Microservice1: X Y Z
Microservice2: A B C

n no. of events-> users events, real-time traffic
10% of event(traffic) ->
feature flagging -

events x y z-> event a b z

-BaseEnrichment
-SpecificEnrichment


 */
