package dadm.project.radarapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;

import dadm.project.radarapp.adapter.EventAdapter;
import dadm.project.radarapp.databinding.ActivityTelaEventosBinding;
import dadm.project.radarapp.model.Event;

public class TelaEventos extends AppCompatActivity {

    private View icone_usuario;
    private TextView nomeUsuario;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private ActivityTelaEventosBinding binding;
    private EventAdapter eventAdapter;
    private ArrayList<Event> eventList = new ArrayList<>();

    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaEventosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        IniciarComponentes();


        icone_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaEventos.this, TelaPerfil.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);

        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    nomeUsuario.setText(documentSnapshot.getString( "nome"));
                }
            }
        });

        RecyclerView recyclerViewEventos = binding.recyclerViewEventos;
        recyclerViewEventos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEventos.setHasFixedSize(true);
        eventAdapter = new EventAdapter(eventList, this);
        recyclerViewEventos.setAdapter(eventAdapter);
        getEventos();

    }
    private void IniciarComponentes(){
        icone_usuario = findViewById(R.id.icone_usuario);
        nomeUsuario = findViewById(R.id.text_nome_usuario);
    }

    private void getEventos(){
        Event event1 = new Event(
                R.drawable.event1,
                "Mysterious 2023 - Fortaleza",
                "Chegamos ao momento em que a linha tênue entre passado, presente e futuro irá se formar e podemos desfrutar do que mais esperávamos. Sensações, memórias e MYSTERIOUS",
                "02/12/2023"
        );
        eventList.add(event1);

        Event event2 = new Event(
                R.drawable.event2,
                "Corona Sunsets World Tour Experience",
                "O festival é conhecido pela sua conexão com a natureza, pelas experiencias imersivas que buscam desconectar seu público da rotina e pela preservação dos locais onde passa, além de celebrar o pôr do sol, ao ritmo de artistas renomados mundialmente.",
                "14/12/2023"
        );
        eventList.add(event2);

        Event event3 = new Event(
                R.drawable.event3,
                "Vintage Culture 2023 - Fortaleza",
                "Save the Date",
                "23/12/2023"
        );
        eventList.add(event3);

        Event event4 = new Event(
                R.drawable.event4,
                "LaPlaya Cumbuco",
                "Estão prontos para nossa segunda edição da LaPlaya?",
                "05/01/2024"
        );
        eventList.add(event4);

        Event event5 = new Event(
                R.drawable.event5,
                "Ensaios da Anitta 2024 - Fortaleza",
                "Anitta, que anualmente faz questão de cantar em diversas cidades brasileiras durante a folia, comemora: “O Carnaval brasileiro é uma das festas populares mais ricas e bonitas do mundo. E é o meu momento preferido do ano.",
                "14/01/2024"
        );
        eventList.add(event5);
    }


}