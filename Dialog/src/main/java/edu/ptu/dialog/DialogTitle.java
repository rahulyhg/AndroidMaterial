package edu.ptu.dialog;

/**
 * Created by WangAnshu on 2016/3/18.
 */
public class DialogTitle {
    private String title;
    private boolean hasClose;

    private DialogTitle() {
    }
    public static class DialogTitleBean{
        private String title;
        private boolean closeOnTitleRight;
    }
    public static class DialogTitleBuilder {
        private final DialogTitle dialogTitle;

        public DialogTitleBuilder(){
            this.dialogTitle=new DialogTitle();
        }

        public DialogTitleBuilder setTitleStr(String title){
            dialogTitle.title=title;
            return this;
        }
        public DialogTitle build(){
            return dialogTitle;
        }
    }
}
