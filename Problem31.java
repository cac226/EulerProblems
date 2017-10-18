/*
IN PROGRESS

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
*/
class Problem31
{
  public static void main(String[] args) {
    int total = 0;
    total++; //make using one 2 pound piece

    int p1   = 200;
    int p2   = 0;
    int p5   = 0;
    int p10  = 0;
    int p20  = 0;
    int p50  = 0;
    int p100 = 0;

    int val = p1*1 + p2*2 + p5*5 + p10*10 + p20*20 + p50*50 + p100*100;


    while(p1 >= 0) //replace all 1p with 2p
    {
      p1 -= 2;
      p2 += 1;
      total++;
    }
    p2 = 0;
    val = p2*2 + p5*5 + p10*10 + p20*20 + p50*50 + p100*100;
    p1 = 200 - val;

    System.out.println(total);
  }
}
