package com.kodilla.testing.lotto;

import java.util.List;

public class MaszynaLosujaca {

    private DataBase dataBase;

    public MaszynaLosujaca(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public int miniLotto(List<Integer> liczbyGracza) {
        if(liczbyGracza.size() != 5){
            return 0;
        }

        for(int i = 0; i <liczbyGracza.size(); i++) {
            if ( (liczbyGracza.get(i) < 1) || (liczbyGracza.get(i) > 36) ) {
                return 0;
            }
        }

        List<Integer> wylosowaneLiczby = dataBase.wylosuj(5);
        int licznikTrafien = 0;

        for(int i = 0; i < 5; i++)  {
            for(int j = 0; j < 5; j++) {
                if(liczbyGracza.get(i) == wylosowaneLiczby.get(j)) {
                    licznikTrafien++;
                }
            }
        }
        return licznikTrafien;
    }

    public int jackpot(List<Integer> liczbyGracza) {
        if( (liczbyGracza.size() != 2) && (liczbyGracza.size() != 5) ){
            return 0;
        }

        if(liczbyGracza.size() == 2) {
            for(int i = 0; i <liczbyGracza.size(); i++) {
                if ( (liczbyGracza.get(i) < 1) || (liczbyGracza.get(i) > 10) ) {
                    return 0;
                }
            }
        }

        if(liczbyGracza.size() == 5) {
            for(int i = 0; i <liczbyGracza.size(); i++) {
                if ( (liczbyGracza.get(i) < 1) || (liczbyGracza.get(i) > 50) ) {
                    return 0;
                }
            }
        }

        List<Integer> wylosowaneLiczby = dataBase.wylosuj(liczbyGracza.size());
        int licznikTrafien = 0;

        for(int i = 0; i < liczbyGracza.size(); i++)  {
            for(int j = 0; j < liczbyGracza.size(); j++) {
                if(liczbyGracza.get(i) == wylosowaneLiczby.get(j)) {
                    licznikTrafien++;
                }
            }
        }
        return licznikTrafien;
    }

}
