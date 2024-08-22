package newmind_2408;

import java.util.*;

public class InsertInterval_57 {
    /* 1. 기존 배열 길이만큼 순회
     * 2. 새로운 배열과 기존 배열을 비교
     * 2-1. if newInterval[1] < intervals[i][0]
     *          then list.add(newInterval)
     *          return list.add(intervals[i:])
     *      if newInterval[0] > intervals[i][1]
     *          then list.add(intervals[i])
     *      fi overlap
     *          then newInterval = min(newInterval[0], intervals[i][0]),
     *                        max(newInterval[1], intervals[i][1])
     * 3. if intervals empty
     *      then list.add(newIntervals)
     * 4. 위 과정이 마무리 되면 2차원 배열 결과 반환
     * */
    private int length = 0;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultIntervals = new ArrayList<>();

        length = intervals.length;
        for (int i=0; i<length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                resultIntervals.add(newInterval);
                return stopSearch(resultIntervals, intervals, i);
            } else if (newInterval[0] > intervals[i][1]) {
                resultIntervals.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        resultIntervals.add(newInterval); // intervals 배열이 비어있을 경우 newIntervals 추가 후 반환
        return resultWrap(resultIntervals);
    }

    private int[][] stopSearch(List<int[]> resultIntervals, int[][] intervals, int remainIndex) {
        for (int i = remainIndex; i<length; i++) {
            resultIntervals.add(intervals[i]);
        }

        return resultWrap(resultIntervals);
    }

    private int[][] resultWrap(List<int[]> resultIntervals) {
        int size = resultIntervals.size();
        int[][] wrap = new int[size][];

        for (int i=0; i<size; i++){
            wrap[i] = resultIntervals.get(i);
        }

        return wrap;
    }

    public static void main(String[] args) {
        InsertInterval_57 test = new InsertInterval_57();
        int[][] intervals = {

        };
        int[] newInterval = {5,7};

        System.out.println(Arrays.deepToString(test.insert(intervals, newInterval)));
    }
}
