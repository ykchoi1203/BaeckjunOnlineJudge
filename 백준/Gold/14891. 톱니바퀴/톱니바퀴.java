import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] r = new int[4][8];

        for(int i=0; i<4; i++) {
            String s = br.readLine();

            for(int j=0; j<8; j++) {
                r[i][j] = s.charAt(j) - '0';
            }
        }

        int r1R = 2;
        int r2L = 6;
        int r2R = 2;
        int r3L = 6;
        int r3R = 2;
        int r4L = 6;

        int n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            switch(num) {
                case 1:
                    if(dir == -1) {
                        if(r[0][r1R] != r[1][r2L]) {
                            if(r[1][r2R] != r[2][r3L]) {
                                if(r[2][r3R] != r[3][r4L]) {
                                    r4L = goRight(r4L);
                                }
                                r3L = goLeft(r3L);
                                r3R = goLeft(r3R);
                            }
                            r2L = goRight(r2L);
                            r2R = goRight(r2R);
                        }
                        r1R = goLeft(r1R);
                    } else {
                        if(r[0][r1R] != r[1][r2L]) {
                            if(r[1][r2R] != r[2][r3L]) {
                                if(r[2][r3R] != r[3][r4L]) {
                                    r4L = goLeft(r4L);
                                }
                                r3L = goRight(r3L);
                                r3R = goRight(r3R);
                            }
                            r2L = goLeft(r2L);
                            r2R = goLeft(r2R);
                        }
                        r1R = goRight(r1R);
                    }
                    break;
                case 2:
                    if(dir == 1) {
                        if(r[1][r2R] != r[2][r3L]) {
                            if(r[2][r3R] != r[3][r4L]) {
                                r4L = goRight(r4L);
                            }
                            r3L = goLeft(r3L);
                            r3R = goLeft(r3R);
                        }

                        if(r[0][r1R] != r[1][r2L]) {
                            r1R = goLeft(r1R);
                        }
                        r2L = goRight(r2L);
                        r2R = goRight(r2R);

                    } else {
                        if(r[1][r2R] != r[2][r3L]) {
                            if(r[2][r3R] != r[3][r4L]) {
                                r4L = goLeft(r4L);
                            }
                            r3L = goRight(r3L);
                            r3R = goRight(r3R);
                        }

                        if(r[0][r1R] != r[1][r2L]) {
                            r1R = goRight(r1R);
                        }
                        r2L = goLeft(r2L);
                        r2R = goLeft(r2R);
                    }
                    break;
                case 3:
                    if(dir == -1) {
                        if(r[1][r2R] != r[2][r3L]) {
                            if(r[0][r1R] != r[1][r2L]) {
                                r1R = goLeft(r1R);
                            }
                            r2L = goRight(r2L);
                            r2R = goRight(r2R);
                        }

                        if(r[2][r3R] != r[3][r4L]) {
                            r4L = goRight(r4L);
                        }

                        r3L = goLeft(r3L);
                        r3R = goLeft(r3R);
                    } else {
                        if(r[1][r2R] != r[2][r3L]) {
                            if(r[0][r1R] != r[1][r2L]) {
                                r1R = goRight(r1R);
                            }
                            r2L = goLeft(r2L);
                            r2R = goLeft(r2R);
                        }

                        if(r[2][r3R] != r[3][r4L]) {
                            r4L = goLeft(r4L);
                        }

                        r3L = goRight(r3L);
                        r3R = goRight(r3R);
                    }
                    break;
                default:
                    if(dir == -1) {
                        if(r[2][r3R] != r[3][r4L]) {
                            if(r[1][r2R] != r[2][r3L]) {
                                if(r[0][r1R] != r[1][r2L]) {
                                    r1R = goRight(r1R);
                                }
                                r2L = goLeft(r2L);
                                r2R = goLeft(r2R);
                            }
                            r3L = goRight(r3L);
                            r3R = goRight(r3R);
                        }
                        r4L = goLeft(r4L);
                    } else {
                        if(r[2][r3R] != r[3][r4L]) {
                            if(r[1][r2R] != r[2][r3L]) {
                                if(r[0][r1R] != r[1][r2L]) {
                                    r1R = goLeft(r1R);
                                }
                                r2L = goRight(r2L);
                                r2R = goRight(r2R);
                            }
                            r3L = goLeft(r3L);
                            r3R = goLeft(r3R);
                        }
                        r4L = goRight(r4L);
                    }
                    break;
            }

        }
        int sum = 0;
        if(r[0][r1R >= 2 ? r1R-2 : r1R + 6] == 1) {
            sum += 1;
        }

        if(r[1][r2R >= 2 ? r2R-2 : r2R + 6] == 1) {
            sum += 2;
        }

        if(r[2][r3R >= 2 ? r3R-2 : r3R + 6] == 1) {
            sum += 4;
        }

        if(r[3][r4L >= 6 ? r4L-6 : r4L + 2] == 1) {
            sum += 8;
        }

        System.out.println(sum);

    }

    public static int goLeft(int idx) {
        return idx == 7 ? 0 : idx + 1;
    }

    public static int goRight(int idx) {
        return idx == 0 ? 7 : idx - 1;
    }
}
