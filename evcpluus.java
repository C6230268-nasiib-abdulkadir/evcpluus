import java.util.Scanner;

public class evcpluus {



        static Scanner input = new Scanner(System.in);
        static String correctPIN = "4545";// pinka aan ku isticmaali doono code ka
        static double haraaga = 400.00; //haraaga defualtiga ah

        static String[] actions = new String[3];// array lagu keydinayo 3 ACTION
        static int actionIndex = 0;






        public static void main(String[] args) {
            while (true) {
                if (!checkCode()) break; // short cutka lagu soo galo(*770#) hadii aad qalado code ka walaga bixi doona
                if (!checkPIN()) break; //pinka haduu qaldan yahy code ka walaga bixi doona

                while (true) {// loop ka evc menu ga
                    showMenu();
                    int choice = input.nextInt();
                    input.nextLine(); // buffer clean

                    switch (choice) {
                        case 1:
                            tusHaraaga();
                            break;
                        case 2:
                            kaarkaHadalka();
                            break;
                        case 3:
                            bixiBiil();
                            break;
                        case 4:
                            uWareejiEVCPlus();
                            break;
                        case 5:
                            warbixinKooban();
                            break;
                        case 6:
                            salaamBank();
                            break;
                        case 7:
                            maareynta();
                            break;
                        case 8:
                            billPayment();
                            break;
                        default:
                            System.out.println("Ma jiro numberkan. fadlan isku day markale.");
                    }



                }
            }
        }

        // Method: Hubinta shortcut ka lagu soo galaayo
        static boolean checkCode() {
            System.out.print("Fadlan geli *770#: ");
            String code = input.nextLine();
            if (!code.equals("*770#")) {
                System.out.println("Code khaldan!");
                return false;
            }
            return true;
        }

        // Method: Hubinta PINka
        static boolean checkPIN() {
            System.out.print("Fadlan geli PIN-kaaga(4 lambar kaliya): ");
            String pin = input.nextLine();
            if (!pin.equals(correctPIN)) {
                System.out.println("<-EVCPLUS-> Nambarka Sirta ah waa Khalad");
                return false;
            }
            return true;
        }

        // Method: Show Menu
        static void showMenu() {
            System.out.println("\n<-EVCPlus->");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka hadalka");
            System.out.println("3. Bixi Biil");
            System.out.println("4. U wareeji EVCPlus");
            System.out.println("5. Warbixin Kooban");
            System.out.println("6. Salaam Bank");
            System.out.println("7. Maareynta");
            System.out.println("8. Bill Payment");
            System.out.print("Dooro number: ");
        }






        //3 dii action ee ugu danbeye ayuu  keydinaa si hadhow uu ugu soo bandhigo qeybta lat 3 action ee qeybta warbixin kooban
        static void addAction(String action) {
            actions[actionIndex % 3] = action;
            actionIndex++;
        }


        // ====halkaan waxaa ka bilabanyo number walbo iyo wixii kusii dhax jiray ====

        // Method: iTus Haraaga 1
        static void tusHaraaga() {
            System.out.println(" Haraaga waa $" + haraaga);
            addAction("Itus Haraaga - $" + haraaga);// waxaa lagu daray kuwa la xisaabin doono hadii
            // la doorto last 3 action hadii 3dii u danbesey
            //ku jiro waala so bandhigi doona hadi kalana wlga taga
        }

        //kaarka hadalka 2
        static void kaarkaHadalka() {

            System.out.println("EVCPlus");
            System.out.println(" Kaarka hadalka");
            System.out.println("1. ku shubo Airtime");
            System.out.println("2. ugu shub airtime");
            System.out.println("3. mifi packages");
            System.out.println("4. ku shubo internet");
            System.out.println("5. ugu shubo  qof kale ");
            System.out.print("Dooro: ");
            int kaarkaOption = input.nextInt();

            switch (kaarkaOption) {
                case 1:
                    System.out.print("Gali lacagta aad rabto inaad ku shubato: ");
                    double lacagta = input.nextDouble();
                    if (lacagta > haraaga) {
                        System.out.println("Haraag kugu filan ma haysid.");
                    } else {
                        haraaga -= lacagta;
                        System.out.println("Waad ku shubatay Airtime $" + lacagta);
                        System.out.println("Haraagaaga cusub waa: $" + haraaga);
                        addAction("Ku shub Airtime $" + lacagta);// waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga

                    }
                    break;

                case 2:
                    System.out.print("Gali lambarka aad ugu shubayso: ");
                    String lambarkaQaataha = input.next();
                    if (lambarkaQaataha.length() != 9) {
                        System.out.println("Lambarka waa in uu noqdaa 9 lambar kaliya.");
                        return;
                    }
                    System.out.print("Gali lacagta aad ugu shubayso: ");
                    double lacagtaUguShubanaysa = input.nextDouble();
                    if (lacagtaUguShubanaysa > haraaga) {
                        System.out.println(" Haraag kugu filan ma haysid.");
                    } else {
                        haraaga -= lacagtaUguShubanaysa;
                        System.out.println("Waxad ugu shubtay $" + lacagtaUguShubanaysa + " lambarka: " + lambarkaQaataha);
                        System.out.println("Haraagaaga cusub waa: $" + haraaga);
                        addAction("Ugu shub Airtime $" + lacagtaUguShubanaysa + " → " + lambarkaQaataha);// waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                        break;
                    }


                case 3:
                    System.out.println(" MIFI Packages");
                    System.out.println("1. 5GB - $5");
                    System.out.println("2. 10GB - $9");
                    System.out.println("3. 20GB - $17");
                    System.out.print("Dooro xirmada: ");
                    int xirmoDoorasho = input.nextInt();
                    double qiimahaXirmada = 0;

                    switch (xirmoDoorasho) {
                        case 1: qiimahaXirmada = 5; break;
                        case 2: qiimahaXirmada = 9; break;
                        case 3: qiimahaXirmada = 17; break;
                        default:
                            System.out.println("Doorasho khaldan!");
                            break;
                    }

                    if (qiimahaXirmada > 0) {
                        if (qiimahaXirmada > haraaga) {
                            System.out.println(" Haraag xisabtada kuguma filana.");
                        } else {
                            haraaga -= qiimahaXirmada;
                            System.out.println("Waxad iibsatay MIFI Package: $" + qiimahaXirmada);
                            System.out.println("Haraagaa waa: $" + haraaga);
                            addAction("MIFI Package $" + qiimahaXirmada);// waxaa lagu daray kuwa la xisaabin doono hadii
                            // la doorto last 3 action hadii 3dii u danbesey
                            //ku jiro waala so bandhigi doona hadi kalana wlga taga

                        }
                    }
                    break;

                case 4:
                    System.out.println("Ku Shubo Internet");
                    System.out.print("Gali lacagta aad rabto inaad internet-ka ugu shubato: ");
                    double lacagtaInternetka = input.nextDouble();
                    if (lacagtaInternetka > haraaga) {
                        System.out.println(" Haraag xisabtada kuguma filana.");
                    } else {
                        haraaga -= lacagtaInternetka;
                        System.out.println("Waxad ku shubatay Internet $" + lacagtaInternetka);
                        System.out.println("Haraagaaga cusub waa: $" + haraaga);
                        addAction("Ku shubo Internet $" + lacagtaInternetka);// waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }
                    break;

                case 5:
                    System.out.println(" Ugu Shub qof kale (MMT)");
                    System.out.print("Gali lambarka qofka aad ugu shubayso: ");
                    String lambarkaMMT = input.next();
                    System.out.print("Gali lacagta aad ugu shubayso: ");
                    double lacagtaMMT = input.nextDouble();
                    if (lacagtaMMT > haraaga) {
                        System.out.println(" Haraag xisabtda kuguma filna.");
                    } else {
                        haraaga -= lacagtaMMT;
                        System.out.println("Waxad ugu shubtay $" + lacagtaMMT + " qofka lambarkiisu yahay: " + lambarkaMMT);
                        System.out.println("Haraagaaga waa: $" + haraaga);

                        addAction("Ugu shub qof kale $" + lacagtaMMT + " → " + lambarkaMMT);// waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }
                    break;

                default:
                    System.out.println("Doorasho khaldan!");
                    break;
            }
        }

        // qEybta BIXI BIIL 3
        static void bixiBiil() {

            System.out.println("EVCPlus");
            System.out.println(" Bixi Biil");
            System.out.println("1. post paid");
            System.out.println("2. ku iibso");
            System.out.print("Dooro number (1 or 2): ");
            int doorasho = input.nextInt();

            switch (doorasho) {
                case 1:
                    System.out.print("Gali lacagta aad rabto inaad ku bixiso Post Paid: ");
                    double lacagPostPaid = input.nextDouble();
                    if (lacagPostPaid <= haraaga) {
                        haraaga -= lacagPostPaid;
                        System.out.println("Wad ku gulesatay lacag bixinta $" + lacagPostPaid + " Post Paid.");
                        System.out.println("Haraagaaga waa: $" + haraaga);
                    } else {
                        System.out.println("Haraagaaga xisabtada kuguma filna.");
                        addAction("Bixi Biil - Post Paid $" + lacagPostPaid); // waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }
                    break;

                case 2:
                    System.out.print("Gali lacagta aad rabto inaad 'Ku Iibso': ");
                    double lacagKuLibso = input.nextDouble();
                    if (lacagKuLibso <= haraaga) {
                        haraaga -= lacagKuLibso;
                        System.out.println("wad ku gulestay libsatay $" + lacagKuLibso + ".");
                        System.out.println("Haraagaaga cusub waa: $" + haraaga);
                    } else {
                        System.out.println("Haraagaaga xisaabtada kuguma filna .");
                        addAction("Bixi Biil - Ku Libso $" + lacagKuLibso);// waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }
                    break;

                default:
                    System.out.println("Doorasho qaldan ayaad sameysay.");

            }

        }
        //QEYBTA U WAREEJI EVCPLUS 4
        static void uWareejiEVCPlus() {
            System.out.println("EVCPlus");
            System.out.println(" U wareeji EVCPlus");
            System.out.print("Fadlan gali mobile number-ka: ");
            String mobileNumber = input.nextLine();
            if (mobileNumber.length() != 9) {
                System.out.println("Lambarka waa in uu noqdaa 9 lambar kaliya.");
                return;
            }
            System.out.println("Numberkan ma ahan mid jiro");
            System.out.print("Fadlan gali lacagta aad rabto inaad wareejiso: ");
            double LacgWreejin=input.nextInt();



            if ( LacgWreejin> haraaga) {
                System.out.println("Haraag kugu filan ma haysid.");
            } else {
                haraaga -=  LacgWreejin;
                System.out.println("<-EVCPlus-> "  +  LacgWreejin+"$  ayaad uwarejiay: " + mobileNumber);
                System.out.println("Haraagaaga cusub waa: $" + haraaga);
                addAction("U wareeji $" + LacgWreejin + " → " + mobileNumber); // waxaa lagu daray kuwa la xisaabin doono hadii
                // la doorto last 3 action hadii 3dii u danbesey
                //ku jiro waala so bandhigi doona hadi kalana wlga taga

            }


        }
        //qeybta warbixin koban 5
        static void warbixinKooban() {

            System.out.println("EVCPlus");
            System.out.println(" Warbixin Kooban");
            System.out.println("1. Last action");
            System.out.println("2. wareejinta u dambesay");
            System.out.println("3.iibsashadii ugu dabesay ");
            System.out.println("4. last 3 action");
            System.out.println("5. Email me my account");
            System.out.print("Dooro number (1 ilaa 5): ");
            int dooro = input.nextInt();

            switch (dooro) {
                case 1:
                    System.out.println(" Last Action");
                    break;

                case 2:
                    System.out.println(" Wareejintii u dambeysay");
                    break;

                case 3:
                    System.out.println(" Libsashadii u dambeysay");
                    break;

                case 4:

                    System.out.println("Last 3 Actions:");

                    for (int i = 0; i < actions.length; i++) { //  last 3 action ayuu xisabina
                        if (actions[i] != null) {
                            System.out.println((i + 1) + ". " + actions[i]);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Waxaad dooratay: Email Me My Activity");
                    break;

                default:
                    System.out.println("Doorasho qaldan ayaad sameysay. Fadlan dooro 1 ilaa 5.");

            }


        }
        // qeybta salam bank 6
        static void salaamBank() {
            System.out.println("evcplus");
            System.out.println("salaam bank");
            System.out.println("1. itus Haraaga");
            System.out.println("2. Lacag dhigasho");
            System.out.println("3.Lacag qadasho ");
            System.out.println("4. Ka wareeji EVCPlus");
            System.out.print("Fadlan dooro (1 ilaa 4): ");
            int doro = input.nextInt();

            switch (doro) {
                case 1:
                    System.out.println("Haraagaaga hadda waa: $" + haraaga);
                    break;

                case 2:
                    System.out.print("Geli lacagta aad rabto inaad dhigato: ");
                    double dhigasho = input.nextDouble();
                    haraaga += dhigasho;
                    System.out.println("Waad dhigtay $" + dhigasho + ". Haraagaaga cusub waa: $" + haraaga);
                    addAction("Lacag dhigasho $" + dhigasho); // waxaa lagu daray kuwa la xisaabin doono hadii
                    // la doorto last 3 action hadii 3dii u danbesey
                    //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    break;

                case 3:
                    System.out.print("Geli lacagta aad rabto inaad qaadato: ");
                    double qaadasho = input.nextDouble();
                    if (qaadasho <= haraaga) {
                        haraaga -= qaadasho;
                        System.out.println("Waad qaaday $" + qaadasho + ". Haraagaaga cusub waa: $" + haraaga);
                    } else {
                        System.out.println("Waan ka xunnahay, haraagaaga kuma filna lacagta aad rabto inaad qaadato.");
                        addAction("Lacag qaadasho $" + qaadasho); // waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }
                    break;

                case 4:
                    System.out.print("Geli lacagta aad rabto inaad ka wareejiso EVCPlus: ");
                    double wareejin = input.nextDouble();
                    if (wareejin <= haraaga) {
                        haraaga -= wareejin;
                        System.out.println("Waad wareejisay $" + wareejin + " EVCPlus. Haraagaaga cusub waa: $" + haraaga);
                    } else {
                        System.out.println("Waan ka xunnahay, haraaga xisaabtada  kuma filna lacagta wareejinta.");
                        addAction("Ka wareeji EVCPlus $" + wareejin); // waxaa lagu daray kuwa la xisaabin doono hadii
                        // la doorto last 3 action hadii 3dii u danbesey
                        //ku jiro waala so bandhigi doona hadi kalana wlga taga
                    }


                default:
                    System.out.println("Doorasho qaldan. Fadlan dooro 1 ilaa 4.");
            }

        }
        //qeybta Maareeynta 7
        static void maareynta() {


            System.out.println("==EVCplus===");
            System.out.println(" Maareynta");
            System.out.println("1. Badal lambarka  sirta ah");
            System.out.println("2. Badal luqada");
            System.out.println("3. Wargelin Mobile Lumay");
            System.out.println("4. Lacag Xirasho");
            System.out.println("5. U celi  lacag qaldantay");
            int Maaraynta_Options=input.nextInt();

            if (Maaraynta_Options == 1) {
                System.out.println("Fadlan Geli PIN kaga cusub");
                int PINCode_Cusub = input.nextInt();
                System.out.println("Hubi PIN-Kaga cusub");
                int ConfirmPINCode = input.nextInt();
                if (ConfirmPINCode == PINCode_Cusub) {
                    System.out.println("[-EVC-Plus] wad ku guleysatay inaa badasho PIN-kaga");
                } else {
                    System.out.println("Confirm PIN code is not matching the new PIN code");
                }

            } else if (Maaraynta_Options == 2) {
                System.out.println("Fadlan Dooro Luqadda: (1. Somali 2. English)");
                int dorashada_luqada = input.nextInt();
                if (dorashada_luqada == 1) {
                    System.out.println("[-EVCPlus-] Waad ku guuleysatay in aad badasho luqadda");
                } else if (dorashada_luqada == 2) {

                    System.out.println("[-EVCPlus-] You have successfully changed your language");
                } else {
                    System.out.println("Selection Error)");
                }


            } else if (Maaraynta_Options == 3) {
                System.out.println("Fadlan Geli Mobile-ka Lumay: ");
                int Mobileka_lumay_PIN_codekisa = 2323;
                int mobileka_lumay = input.nextInt();
                System.out.println("Fadlan Geli Number-kisa sirta ah: ");
                int LostMobilePINCode = input.nextInt();
                if (LostMobilePINCode == Mobileka_lumay_PIN_codekisa) {
                    System.out.println("Waad ku mahadsan tahay wargelintada waxaana kugu adeegi doonnaa sida ugu dhaqsiyaha badan");
                } else {
                    System.out.println("Number sireedka aad galisay waa qalad , Fadlan ku celi mar kle");
                }


            } else if (Maaraynta_Options == 4) {
                System.out.println("Fadlan Geli Number-ka lagu khalday: ");
                int Lagu_Khalday = input.nextInt();
                System.out.println("Fadlan Geli Lambarka loo waday: ");
                int Numberka_lowaday = input.nextInt();
                System.out.println("Fadlan Geli Macluumaad");

                String Maclumad = input.nextLine().trim().toLowerCase();
                System.out.println("Ma hubtaa inaad xirato lacagta (1. Haa 2. Maya)");
                int Maclumad_Yes_Or_No = input.nextInt();

                if (Maclumad_Yes_Or_No == 1) {
                    System.out.println("Waxaan kuugu adeegi doonna sida ugu dhaqsiyaha badan Mahadsanid!");
                } else {
                    System.out.println("Mahadsanid");
                }

            }

        }
        // qeybta billpeymant 8
        static void billPayment() {
            System.out.println("EVCPlus");
            System.out.println(" Bill Payment");
            System.out.println("1. Itus haraaga bill ka");
            System.out.println("2. Wada bixi bill-ka");
            System.out.println("3. Qeyb ka bixi bill-ka ");
            int Bill_Payement_Options=input.nextInt();


            //Haraga
            if (Bill_Payement_Options == 1) {
                System.out.println("Fadlan Geli numberka tixraaca: ");
                int Numberka_Tixraaca = input.nextInt();
                System.out.println("Haraagaagu Bill-ka waa $500");

                //wada bixnta bill-ka
            } else if (Bill_Payement_Options == 2) {
                System.out.println("Fadlan Geli Reference Number: ");
                int Numberka_Tixraca = input.nextInt();
                System.out.println("Waa lawada Bixiyay Bill-ka! Mahadsanid");
                addAction("Wada bixinta Bill-ka"); // waxaa lagu daray kuwa la xisaabin doono hadii
                // la doorto last 3 action hadii 3dii u danbesey
                //ku jiro waala so bandhigi doona hadi kalana wlga taga

                //Qeybta ka bixida
            } else if (Bill_Payement_Options == 3) {
                System.out.println("Fadlan Geli Number-ka aad udirayso Bill-ka");
                int To_Bill_user = input.nextInt();
                System.out.println("Fadlan Geli Lacagta Bill-ka");
                double Lacagta_Billka = input.nextDouble();
                System.out.println("Waxaad ku guuleysatay inaad qayb ka bixiso Bill-ka!  Mahadsanid");
                addAction("Qeyb ka bixinta Bill-ka $" + Lacagta_Billka); // waxaa lagu daray kuwa la xisaabin doono hadii
                // la doorto last 3 action hadii 3dii u danbesey
                //ku jiro waala so bandhigi doona hadi kalana wlga taga

            } else {
                System.out.println("Haraagaga kuma filna inaad bixiso qaybta bill-ka.");
            }



        }


}


