package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder{
    CheckBox chkbox;
    TextView txtToDo;
    View view;

    public ToDoViewHolder(View v){
        super(v);
        view = v;
        chkbox = v.findViewById(R.id.checkBox);
        txtToDo = v.findViewById(R.id.textView);

    }

}
