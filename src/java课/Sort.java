package java课;

public class Sort {
    //冒泡排序
        public static int[] bubbleSort (int[] arr){
            if(arr.length==0)
                return arr;
            for(int i=1;i<arr.length;i++){
                for(int j=0;j<arr.length-i;j++){
                    if(arr[j]>arr[j+1]){
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
                for(int k=0;k<arr.length;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            return arr;
        }
        //选择排序
        public static int[] selectionSort(int[] arr){
            if(arr.length==0)
                return arr;
            for(int i=0;i<arr.length;i++){
                int minindex=i;
                for(int j=i;j<arr.length;j++){
                    if(arr[j]<arr[minindex])
                        minindex=i;
                }
                int temp=arr[minindex];
                arr[minindex]=arr[i];
                arr[i]=temp;
            }
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
            return arr;
        }
        //插入排序
        public static int[] insertSort(int[] arr){
            if(arr.length==0)
                return arr;
            int current;
            for(int i=0;i<arr.length-1;i++){
                current=arr[i+1];
                int preindex=i;
                while(preindex>=0&&current<arr[preindex]){
                    arr[preindex+1]=arr[preindex];
                    preindex--;
                }
                arr[preindex+1]=current;
                for(int k=0;k<arr.length;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            return arr;
        }


        public static void main(String[] args){
            int[] arr={9,8,3,5,2,4,12,0};
            for( int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            //bubbleSort(arr);
            //selectionSort(arr);
            insertSort(arr);
        }
    }

