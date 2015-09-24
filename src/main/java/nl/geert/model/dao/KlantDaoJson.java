package nl.geert.model.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nl.geert.model.Klant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Geert
 */
public class KlantDaoJson implements KlantDao {

    ObjectMapper mapper = new ObjectMapper();
    List<Klant> list = new ArrayList<>();
    File file = new File("d:\\klanten.json");

    @Override
    public void create(Klant klant) {
        try {
            if (file.exists()) {
                //convert user object to json string, and save to a file
                list = mapper.readValue(file, List.class);

            }
            list.add(klant);
            mapper.writeValue(file, list);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void update(Klant klant) {
        try {
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            for (Klant klantje : list) {
                if (klantje.getKlant_id() == klant.getKlant_id()) {
                    klantje.setVoornaam(klant.getVoornaam());
                    klantje.setAchternaam(klant.getAchternaam());
                    klantje.setTussenvoegsel(klant.getTussenvoegsel());
                    klantje.setEmail(klant.getEmail());


                }
            }
            mapper.writeValue(file, list);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Klant read(int id) {
        Klant klant = null;
        try {
            //read from file, convert it to user class
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            for (Klant klantje : list) {
                if (klantje.getKlant_id() == id) {
                    klant = klantje;
                }

            }
            //display to console
            System.out.println(klant.getVoornaam() + ", " + klant.getAchternaam() + ", " + klant.getEmail());

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return klant;
    }

    @Override
    public Klant read(String voornaam, String achternaam) {
        Klant klant = null;
        try {
            //read from file, convert it to user class
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            for (Klant klantje : list) {
                if (klantje.getVoornaam().equals(voornaam) && klantje.getAchternaam().equals(achternaam)) {
                    klant = klantje;
                }

            }
            //display to console
            System.out.println(klant.getVoornaam() + ", " + klant.getAchternaam() + ", " + klant.getEmail());

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return klant;
    }

//    @Override
//    public Klant read(String postcode, int huisnummer) {
//
//        Klant klant = null;
//        try {
//            //read from file, convert it to user class
//            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
//            });
//            for (Klant klantje : list) {
//                if (klantje.getPostcode().equals(postcode) && (klantje.getHuisnummer() == huisnummer)) {
//                    klant = klantje;
//                }
//
//            }
//            //display to console
//            System.out.println(klant.getVoornaam() + ", " + klant.getAchternaam() + ", " + klant.getEmail());
//
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return klant;
//    }

    @Override
    public void delete(int id) {
       try {
            //read from file, convert it to user class
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            List<Klant> copy = new ArrayList<>(list);
            System.out.println(copy.get(1).getAchternaam());
            for (Klant klantje : list) {
                if (klantje.getKlant_id() == id) {
                    copy.remove(klantje);
                }

            }
            
           mapper.writeValue(file, copy);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void delete(String voornaam, String tussenvoegsel, String achternaam) {
        try {
            //read from file, convert it to user class
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            List<Klant> copy = new ArrayList<>(list);
            System.out.println(copy.get(1).getAchternaam());
            for (Klant klantje : list) {
                if (klantje.getVoornaam().equals(voornaam) && klantje.getTussenvoegsel().equals(tussenvoegsel) && klantje.getAchternaam().equals(achternaam)) {
                    copy.remove(klantje);
                }

            }
            
           mapper.writeValue(file, copy);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void delete(String voornaam, String achternaam) {
        try {
            //read from file, convert it to user class
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
            List<Klant> copy = new ArrayList<>(list);
            System.out.println(copy.get(1).getAchternaam());
            for (Klant klantje : list) {
                if (klantje.getVoornaam().equals(voornaam) && klantje.getAchternaam().equals(achternaam)) {
                    copy.remove(klantje);
                }

            }
            
           mapper.writeValue(file, copy);

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Klant> getAll() {
        list = null;
        try {
            list = mapper.readValue(file, new TypeReference<List<Klant>>() {
            });
        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }
}
