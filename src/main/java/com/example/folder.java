package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class folder {
    public static void createFile() {
        File f1 = new File("/Counter Files");
        File f2 = new File("/Counter Files\\Saves");
        JsonObject fileData = JsonParser.parseString("{}").getAsJsonObject();
        File myObj = new File("/Counter Files\\settings.txt");
        try {
            myObj.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (readGame("/Counter Files\\settings.txt") != null) {
            fileData = readGame("/Counter Files\\settings.txt");
        } else if (readGame("/Counter Files\\settings.txt") == null) {
            fileData = readGame("/Counter Files\\settings.txt");
            try {
                FileWriter myWriter = new FileWriter("/Counter Files\\settings.txt");
                myWriter.write(String.valueOf(
                        "{Color1:192FFF,Color2:FF2628,Color3:4AFF7C,Color4:FFD132,Buton1:1,Buton2:2,Buton3:3,Buton4:4,Buton5:5,Buton6:6,PauseT:p,Value1:1,Value2:2,Value3:-1,Value4:1,Value5:2,Value6:-1}"));
                myWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            if (String.valueOf(fileData).equals("{}")) {
                fileData.addProperty("contentAmount", "0");
                fileData.addProperty("team1Count", "0");
                fileData.addProperty("team2Count", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f1.mkdir();
        boolean bool = f2.mkdir();
        if (bool) {
        } else if (f1.exists()) {
        } else {
        }
    }

    public static void Log(int action) {
        if (!(action >= 7)) {
            JsonObject fileData = readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt");
            final JsonObject original = fileData;
            int count = 0;
            int toBeAdded = 0;
            try {
                int templength = 0;
                while (true) {
                    templength++;
                    if (JsonManager.getFieldOrNA(String.valueOf(templength), fileData).equals("N/A")) {
                        break;
                    }
                }

                fileData.addProperty(String.valueOf(templength), action);

                if (action == 1) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team1Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value1", folder.readGame("/Counter Files\\settings.txt")));

                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team1Count", count + toBeAdded);

                } else if (action == 2) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team1Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value2", folder.readGame("/Counter Files\\settings.txt")));
                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team1Count", count + toBeAdded);
                } else if (action == 3) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team1Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value3", folder.readGame("/Counter Files\\settings.txt")));
                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team1Count", count + toBeAdded);
                } else if (action == 4) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team2Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value4", folder.readGame("/Counter Files\\settings.txt")));
                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team2Count", count + toBeAdded);
                } else if (action == 5) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team2Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value5", folder.readGame("/Counter Files\\settings.txt")));
                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team2Count", count + toBeAdded);
                } else if (action == 6) {
                    count = Integer.valueOf(JsonManager.getFieldOrNA("team2Count", fileData));
                    toBeAdded = Integer.valueOf(
                            JsonManager.getFieldOrNA("Value6", folder.readGame("/Counter Files\\settings.txt")));
                    if (count + toBeAdded > 999 || count + toBeAdded < -99) {
                        return;
                    }
                    fileData.addProperty("team2Count", count + toBeAdded);
                }

                if (!(count + toBeAdded > 999 || count + toBeAdded < -99)) {
                    fileData.addProperty("contentAmount",
                            Integer.parseInt(JsonManager.getFieldOrNA("contentAmount", fileData)) + 1);
                }

                try {
                    FileWriter myWriter = new FileWriter(
                            "/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt");
                    myWriter.write(String.valueOf(fileData));
                    myWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } catch (Exception e) {
            }

        } else if (action == 10) {
            NewGame(recent() + 1);
            Stopwatch.stop();
            Stopwatch.stopStart = false;
            Stopwatch.elapsedTime = 0;
            Stopwatch.time = System.nanoTime();
            Stopwatch.savedTime = 0;
            Gui.stopwatch.setText("0:00:00:000");
        }
    }

    public static void NewGame(int number) {
        JsonObject fileData = JsonParser.parseString("{}").getAsJsonObject();
        File myObj = new File("/Counter Files\\Saves\\" + number + ".txt");
        try {
            myObj.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Read the file
        if (readGame("/Counter Files\\Saves\\" + number + ".txt") != null) {
            fileData = readGame("/Counter Files\\Saves\\" + number + ".txt");
        }
        // write to file
        try {
            FileWriter myWriter = new FileWriter("/Counter Files\\Saves\\" + number + ".txt");
            if (String.valueOf(fileData).equals("{}")) {
                fileData.addProperty("contentAmount", "0");
                fileData.addProperty("team1Count", "0");
                fileData.addProperty("team2Count", "0");
            } else {
                int templength = 0;
                while (true) {
                    templength++;
                    if (JsonManager.getFieldOrNA(String.valueOf(templength), fileData).equals("N/A")) {
                        break;
                    }
                }
            }
            myWriter.write(String.valueOf(fileData));
            myWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static JsonObject readGame(String path) {
        JsonObject data = null;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                data = JsonParser.parseString(temp).getAsJsonObject();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred while reading game number " + path);
            e.printStackTrace();
        }
        return data;
    }

    public static int recent() {
        int i = 1;
        while (new File("/Counter Files\\Saves\\" + i + ".txt").isFile()) {
            i++;
        }
        i--;
        return i;
    }

    public static void deletelast() {
        JsonObject fileData = readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt");
        int contentAmount = Integer.parseInt(JsonManager.getFieldOrNA("contentAmount", fileData));
        if (contentAmount == 0) {
            return;
        }
        fileData.addProperty("contentAmount", contentAmount - 1);

        int toBeRemoved = Integer.parseInt(JsonManager.getFieldOrNA(String.valueOf(contentAmount), fileData));

        int t1 = Integer.parseInt(JsonManager.getFieldOrNA("team1Count", fileData));
        int t2 = Integer.parseInt(JsonManager.getFieldOrNA("team2Count", fileData));

        if (toBeRemoved == 1) {
            fileData.addProperty("team1Count", t1 - Integer.parseInt(JsonManager.getFieldOrNA("Value1",
                    folder.readGame("/Counter Files\\settings.txt"))));
        } else if (toBeRemoved == 2) {
            fileData.addProperty("team1Count", t1 - Integer.parseInt(JsonManager.getFieldOrNA("Value2",
                    folder.readGame("/Counter Files\\settings.txt"))));
        } else if (toBeRemoved == 3) {
            fileData.addProperty("team1Count", t1 - Integer.parseInt(JsonManager.getFieldOrNA("Value3",
                    folder.readGame("/Counter Files\\settings.txt"))));
        } else if (toBeRemoved == 4) {
            fileData.addProperty("team2Count", t2 - Integer.parseInt(JsonManager.getFieldOrNA("Value4",
                    folder.readGame("/Counter Files\\settings.txt"))));
        } else if (toBeRemoved == 5) {
            fileData.addProperty("team2Count", t2 - Integer.parseInt(JsonManager.getFieldOrNA("Value5",
                    folder.readGame("/Counter Files\\settings.txt"))));
        } else if (toBeRemoved == 6) {
            fileData.addProperty("team2Count", t2 - Integer.parseInt(JsonManager.getFieldOrNA("Value6",
                    folder.readGame("/Counter Files\\settings.txt"))));
        }

        fileData.remove(String.valueOf(contentAmount));

        try {
            FileWriter myWriter = new FileWriter("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt");
            myWriter.write(String.valueOf(fileData));
            myWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Gui.l1.setText(JsonManager.getFieldOrNA("team1Count",
                folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));

        Gui.l2.setText(JsonManager.getFieldOrNA("team2Count",
                folder.readGame("/Counter Files\\Saves\\" + String.valueOf(folder.recent()) + ".txt")));
    }
}
