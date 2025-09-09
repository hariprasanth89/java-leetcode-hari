package org.example.leetcode;


public class RemoveDuplicatesfromSortedArray26 {

    public static int removeDuplicates(int[] nums){
        if(nums.length <=1){ // If the array has 0 or 1 element, no duplicates to remove, return its length
            return nums.length; // Return the length as is
        }
        int count = 0; // Initialize a pointer 'count' to keep track of the position for the next unique element
        for(int i = 1; i < nums.length; i++){ // Iterate through the array starting from the second element
            if(nums[count] != nums[i]){ // If the current element (nums[i]) is different from the last unique element (nums[count])
                nums[++count] = nums[i]; // Increment 'count' and place the current unique element at the new 'count' position
            }
        }
        //Arrays.stream(nums).forEach(System.out::println);
        return ++count; // Increment 'count' one last time to get the total number of unique elements (since 'count' is 0-indexed)
    }
    public static int removeDuplicatesDiff(int[] nums) {
        if(nums.length <= 1){
            return nums.length -1;
        }
        int count = 0;
        for(int i = 1; i < nums.length ; i++){
            if(nums[count] != nums[i]){
                nums[++count] = nums[i];
            }
        }
        return ++count;
    }

    public static void main(String[] args) {
        // Define an array with duplicate elements
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // Call the removeDuplicates method to process the array
        int removeDuplicates = removeDuplicates(arr);
        System.out.println("Result : "+removeDuplicates);
        // Print the unique elements of the modified array
        for(int i = 0; i < removeDuplicates; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(removeDuplicatesDiff(new int[]{1,1,2,2,3,3}));
    }

}
