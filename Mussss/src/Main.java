import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {

    private static final String IN_FILE_TXT = "src\\in.txt";
    private static final String OUT_FILE_TXT = "src\\out.txt";
    private static final String PATH_TO_MUSIC = "src\\music\\";

    private static final String IN_PIC_TXT = "src\\inpic.txt";
    private static final String OUT_PIC_TXT = "src\\outpic.txt";
    private static final String PATH_PIC = "src\\picture\\";


    public static void main(String[] args) {
         String Url;
        try (BufferedReader inFile = new BufferedReader(new FileReader(IN_FILE_TXT));
             BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT))) {
            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);
                String result;
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    result = bufferedReader.lines().collect(Collectors.joining("\n"));
                }
                //https://ru.hitmotop.com/get/music/20210604/Filatov_Karas_GAYAZOV_BROTHER_-_Poshla_zhara_72992182.mp3
                //https://ru.hitmotop.com/get/music/20220603/ANNA_ASTI_-_Po_baram_74376135.mp3

                Pattern patternMus = Pattern.compile("https:\\/\\/ru.hitmotop.com\\/get\\/music\\/(.+).mp3");
                Matcher matcher = patternMus.matcher(result);
                int i = 0;
                while (matcher.find() & i < 5) {
                    outFile.write(matcher.group() + "\r\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader musicFile = new BufferedReader(new FileReader(OUT_FILE_TXT))) {
            String music;
            int count = 1;
            try {
                while ((music = musicFile.readLine()) != null) {
                    System.out.println("Песня " + count + " скачалась");
                    downloadUsingNIO(music, PATH_TO_MUSIC + count + ".mp3");
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String UrlPIC;
        try (BufferedReader inFilePic = new BufferedReader(new FileReader(IN_PIC_TXT));
             BufferedWriter outFilePic = new BufferedWriter(new FileWriter(OUT_PIC_TXT))) {
            while ((UrlPIC = inFilePic.readLine()) != null) {
                URL urlP = new URL(UrlPIC);

                String resultPic;
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlP.openStream()))) {
                    resultPic = bufferedReader.lines().collect(Collectors.joining("\n"));
                }
                //https://flomaster.club/uploads/posts/2022-08/thumbs/1660206830_1-flomaster-club-p-raskraski-dlya-mladshikh-shkolnikov-krasiv-1.jpg
                //https://flomaster.club/uploads/posts/2022-08/thumbs/1660206824_2-flomaster-club-p-raskraski-dlya-mladshikh-shkolnikov-krasiv-2.jpg
                Pattern patternPIC = Pattern.compile("https:\\/\\/flomaster.club\\/uploads\\/posts\\/2022-08\\/thumbs\\/(.+).jpg");
                Matcher matcherPIC = patternPIC.matcher(resultPic);
                int i = 0;
                while (matcherPIC.find() & i < 3) {
                    outFilePic.write(matcherPIC.group() + "\r\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader picFile = new BufferedReader(new FileReader(OUT_PIC_TXT))) {
            String picture;
            int count = 1;
            try {
                while ((picture = picFile.readLine()) != null) {
                    System.out.println("Картинка " + count + " скачалась");
                    downloadUsingNIO(picture, PATH_PIC + count + ".jpg");
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream inputStream = new FileInputStream("src\\music\\6.mp3")) {
            try {
                Player player = new Player(inputStream);
                System.out.println("Воспроизведение песни");
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
    private static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL urlP = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(urlP.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }


}

