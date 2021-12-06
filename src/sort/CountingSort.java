package sort;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int[] counting = new int[31];
        int[] result = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 31);
        }

        for(int i = 0; i < arr.length ; i++){
            //arr의 값을 index로 하는 counting 배열 값 1 증가
            counting[arr[i]]++;
        }

        for(int i = 1; i < counting.length; i++){
            //누적 합 구하기
            counting[i] += counting[i - 1];
        }

        for(int i = arr.length - 1; i >= 0; i--){
            //i번째 원소를 인덱스로 하는 counting 배열을 1 감소시키고
            //counting 배열의 값을 인덱스로 하여 result 저장
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        /* 비교 출력 */

        // 초기 배열
        System.out.println("array[]");
        for(int i = 0; i < arr.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n\n");


        // Counting 배열
        System.out.println("counting[]");
        for(int i = 0; i < counting.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(counting[i] + "\t");
        }
        System.out.println("\n\n");


        // 정렬된 배열
        System.out.println("result[]");
        for(int i = 0; i < result.length; i++) {
            if(i % 10 == 0) System.out.println();
            System.out.print(result[i] + "\t");
        }
        System.out.println();

    }
}
