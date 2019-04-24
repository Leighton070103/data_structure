package tests.toutiao;


import java.util.*;

public class Cat {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testcaseNum = getInt(scanner.nextLine());
        int[] frameNum = new int[testcaseNum];
        TestCase[] testCases = new TestCase[testcaseNum];
        for (int i=0; i<testcaseNum; i++){
            frameNum[i] = getInt(scanner.nextLine());
            testCases[i] = new TestCase(frameNum[i]);
            for (int j=0; j<frameNum[i]; j++){
                testCases[i].addFrame(scanner.nextLine().split(" "));
            }
        }
        for (TestCase testCase: testCases){
            System.out.println(testCase.max>0? testCase.max:1);
        }
    }

    public static int getInt(String s){
      return    Integer.parseInt(s);
    }

    static class Feature{
        int x;
        int y;
        public Feature(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Feature feature = (Feature) obj;
            return this.x == feature.x && this.y == feature.y;
        }

        @Override
        public int hashCode() {
            return x*310+y*31;
        }
    }

    static class TestCase{
        int frameNum;
        List<Feature> features;
        List<Integer> lengths;
        int max;
        public TestCase(int frameNum){
            this.frameNum = frameNum;
            features = new ArrayList<>();
            lengths = new LinkedList<>();
            max=0;
        }

        public void addFrame(String[] nums){
            if (nums.length==1) return;
            Boolean[] consistencies = new Boolean[lengths.size()];
            for (int i=1; i<nums.length-1; i+=2){
               int index = addFeature(new Feature(getInt(nums[i]), getInt(nums[i+1])));
               if (index!=-1) consistencies[index]=true;
            }
            for (int j=0; j<consistencies.length; j++){
                if (consistencies[j]==null) lengths.set(j, 0);
            }
        }

        public int addFeature(Feature feature){
            int val=1;
            int index=-1;
            if (features.contains(feature)){
                index = features.indexOf(feature);
                val = lengths.get(index);
                val++;
                lengths.set(index, val);
            }
            else {
                features.add(feature);
                lengths.add(val);
            }
            if (max < val) max= val;
            return index;
        }
    }

}
