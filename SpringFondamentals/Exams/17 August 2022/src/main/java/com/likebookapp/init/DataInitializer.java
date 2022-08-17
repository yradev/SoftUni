package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final MoodRepository moodRepository;

    public DataInitializer(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(moodRepository.count()==0){
            for (MoodName value : MoodName.values()) {
                Mood mood = new Mood();
                mood.setName(value);
                moodRepository.saveAndFlush(mood);
            }

        }
    }
}
