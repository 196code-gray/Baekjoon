import java.util.*;
import java.io.*;

public class Main {

    public static int RemainPongDang(int nN, int nR) {
        int nSum = 0;

        for (int i = 1; i < nR; i++) {
            if (i > 2 * nN) {
                nSum += 4 * nN - i;
            } else {
                nSum += i;
            }
        }

        return nSum;
    }

    public static int PongDang(int nN, int nP, int nT) {
        int nRotHand = 4 * nN * nN - 1;
        int nRotT = 4 * nN - 2;

        int nRRot = nRotHand % (2 * nN);
        int nR = nT % nRotT;

        int nHand_Pos = (nRRot * (nT / nRotT) + RemainPongDang(nN, nR)) % (2 * nN);
        int nHand_Remain = 0;

        if (nR > 2 * nN)
            nHand_Remain += 4 * nN - nR;
        else
            nHand_Remain += nR;

        for (int i = 0; i < nHand_Remain; i++) {
            nHand_Pos += 1;

            if (nHand_Pos > (2 * nN))
                nHand_Pos %= (2 * nN);

            if (nHand_Pos == (2 * nP - 1) || nHand_Pos == 2 * nP)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nN = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int nP = Integer.parseInt(st.nextToken());
        int nT = Integer.parseInt(st.nextToken());

        if (PongDang(nN, nP, nT) == 1)
            System.out.println("Dehet YeonJwaJe ^~^");
        else
            System.out.println("Hing...NoJam");
    }
}