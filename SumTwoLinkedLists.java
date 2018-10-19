class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode output = null, header = null, nonEmptyList=null;
        while((l1 !=null) && (l2 !=null)){
                    sum = carry + l1.val+l2.val;
                    carry = sum/10;
                    sum = sum % 10;
                if(header == null){
                    header = new ListNode(sum);
                    output = header;
                } else {
                    output.next = new ListNode(sum);
                    output = output.next;
                }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 != null)
            nonEmptyList = l2;
        else if(l1 !=null)
            nonEmptyList = l1;
        
        while(nonEmptyList !=null){
            sum = carry + nonEmptyList.val;
            carry = sum / 10;
            sum = sum % 10;
            output.next = new ListNode(sum);
            nonEmptyList = nonEmptyList.next;
            output = output.next;
        }
        if(carry != 0){
            output.next = new ListNode(carry);
        }
        return header;
    }
}
