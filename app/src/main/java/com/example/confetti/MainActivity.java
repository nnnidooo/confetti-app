package com.example.confetti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;
    private Party party = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        konfettiView = findViewById(R.id.konfettiView);

        EmitterConfig emitterConfig = new Emitter(200, TimeUnit.MILLISECONDS).perSecond(50);
        PartyFactory partyFactory = new PartyFactory(emitterConfig);
        partyFactory.spread(360);
        partyFactory.colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def));
        partyFactory.setSpeedBetween(0f, 30f);
        partyFactory.position(new Position.Relative(0.5, 0.3));
        party = partyFactory
                .build();

    }

    public void showConfetti(View view) {
        konfettiView.start(party);
    }
}

