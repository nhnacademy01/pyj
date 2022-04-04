//package cleanCode;
//
//public class CleanCode {
//
//
//    public static void main(String[] args) {
//
//    }
//
//
//    private static void Example1(){
//        if(userResult != SUCCESS){
//            error(userResult);
//            return ;
//        }
//        if(permissionResult != SUCCESS){
//            error("error reading permissions");
//            return ;
//        }
//
//        success();
//    }
//    private static void error(String str){
//        reply.WriteErrors(str);
//        reply.Done();
//    }
//
//    private static void success(){
//        reply.WriteErrors("");
//        reply.Done();
//    }
//
//    private static void Example2(){
//        def ViewFilteredReplies(original_id):
//            root_message = Message.objects.get(original_id);
//            root_message.view_count += 1;
//            root_message.last_view_time = datetime.datetime.now();
//            root_message.save();
//
//
//            filtered_replies = [];
//            for reply in (Message.objects.select(original_id)):
//                if reply.spam_votes <= MAX_SPAM_VOTES;
//                    filtered_replies.append(reply)
//
//            return filtered_replies
//    }
//}
