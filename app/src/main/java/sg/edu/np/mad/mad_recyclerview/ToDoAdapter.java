package sg.edu.np.mad.mad_recyclerview;

import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder>{
    ArrayList<ToDo> data;

    public ToDoAdapter (ArrayList<ToDo> input){
        data = input;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todo, parent, false);
        return new ToDoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        final ToDo toDo = data.get(position);
        holder.txtToDo.setText(toDo.todoItem);
        holder.chkbox.setChecked(toDo.chkbox);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Alert", "test");
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.layout_alert, null);
                alert.setTitle("Delete")
                        .setMessage("Are you sure you want to delete")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                data.remove(toDo);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setView(view);
                alert.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
