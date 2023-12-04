package dadm.project.radarapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dadm.project.radarapp.databinding.EventItemBinding;
import dadm.project.radarapp.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private final ArrayList<Event> eventList;
    private final Context context;

    public EventAdapter(ArrayList<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }


    @NonNull
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemBinding listItem;
        listItem = EventItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new EventViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder, int position) {
        holder.binding.imagemEvent.setBackgroundResource(eventList.get(position).getImgEvento());
        holder.binding.txtEventName.setText(eventList.get(position).getNomeEvento());
        holder.binding.txtEventDescription.setText(eventList.get(position).getDescricaoEvento());
        holder.binding.txtData.setText(eventList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{

         EventItemBinding binding;

        public EventViewHolder(EventItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
