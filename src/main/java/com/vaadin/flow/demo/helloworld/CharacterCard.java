/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.helloworld;

import com.vaadin.flow.demo.helloworld.CharacterCard.CharacterCardModel;
import com.vaadin.flow.model.TemplateModel;
import com.vaadin.ui.Tag;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

import java.util.Random;

/**
 * Simple template example.
 */
@Tag("character-card")
@HtmlImport("CharacterCard.html")
public class CharacterCard extends PolymerTemplate<CharacterCardModel> {

    private static String[] nameParts = { "am", "bet", "c", "de", "ef", "gg", "ij", "ko", "la", "me", "ni", "ou", "peh", "q", "ru", "s", "teh", "uw", "ve",
        "wy", "x", "yy", "zap" };

    public CharacterCard() {

    }

    public static CharacterCard createRandom() {
        Random random = new Random(System.currentTimeMillis());
        CharacterCard card = new CharacterCard();
        int maxHP = random.nextInt(128);
        int hp = maxHP- random.nextInt(maxHP);
        card.getModel().setMaxHitpoints(maxHP);
        card.getModel().setHitpoints(hp < 0 ? 0 : hp);
        String name = "";
        for (int i = 0; i <= random.nextInt(3) + 1; i++) {
            name += nameParts[random.nextInt(nameParts.length - 1)];
        }
        char c = name.charAt(0);
        name = Character.toUpperCase(c) + name.substring(1);
        card.getModel().setName(name);
        int imageIdx = random.nextInt(3);
        String portrait = "";
        switch (imageIdx) {
        case 0:
            portrait = "red.png";
            break;
        case 1:
            portrait = "green.png";
            break;
        default:
            portrait = "blue.png";

        }
        card.getModel().setPortrait(portrait);
        card.getModel().setJob(Job.randomJob().toString());
        return card;
    }

    public interface CharacterCardModel extends TemplateModel {
        void setName(String name);

        void setPortrait(String portrait);

        void setHitpoints(Integer hitpoints);

        void setMaxHitpoints(Integer maxHitpoints);

        void setJob(String job);
    }

}
