#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void gotoxy(int x, int y)
{

	COORD pos = { x - 1, y - 1 };//커서가 X좌표에서 -1 한값. Y좌표에서 -1한 값으로 이동

	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);// WIN32API 함수

}

void textcolor(int color_number)
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color_number);
}

int S[20][3] = { 0 };
int S2[5][3] = { 0 };
int E[30][100] = { 0 };

int main()
{
	int Sspeed = 10000000, S2speed = 10200000;
	int x, y, zx = 0, x1, y1, jumsu = 0, jumsu1 = 0, life = 0, Ecnt = 0;
	int x2 = 3, y2 = 4;

	int i, ey = 0, ex = 0, start = 0, L = 3; //L은 뱀의 길이

	int speed = 1;

	int test;


	while (!_kbhit())
	{
		Sleep(30);

		gotoxy(28, 15);
		test = rand() % 15;
		textcolor(test);
		printf("프로그래머");
		textcolor(13);
		gotoxy(24, 17);
		printf("Enter를 누르면 게임이 시작됩니다!");
	}
	system("cls");
	textcolor(10);
	gotoxy(1, 2);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	gotoxy(1, 24);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	textcolor(14);
	gotoxy(45, 1);
	printf("당신의 점수:%3d점", jumsu);
	textcolor(14);
	gotoxy(3, 1);
	printf("적뱀의 점수:%3d점", jumsu1);
	gotoxy(69, 1);
	printf("목숨 : ");

	y = 20;
	x = 70;

	for (i = 1; i <= 10; i = i + 1)
	{
		ey = rand() % 21 + 3;
		ex = rand() % 76 + 4;
		E[ey][ex] = 1;//먹이 배열에 표시
		textcolor(13);
		gotoxy(ex, ey);
		printf("$");
	}

	while (1)
	{
		speed += 1;
		if (speed>100000000)speed = 1;

		if (speed % Sspeed == 0)
		{
			if (_kbhit()) { zx = _getch(); }

			if (zx == 119)y = y - 1;//위

			if (zx == 115)y = y + 1;//아래

			if (zx == 97)x = x - 1;//왼쪽

			if (zx == 100)x = x + 1;//오른쪽

			if (zx == 27)break; //ESC

								///////////////////////////////

			if (x == 80)x = 2;               //통과구간

			if (x == 1)x = 79;

			if (y == 24)y = 3;

			if (y == 2)y = 23;

			//////////////////////////////

			for (i = L - 1; i >= 0; i--)
			{
				S[i + 1][1] = S[i][1];

				S[i + 1][2] = S[i][2];
			}

			gotoxy(S[L][2], S[L][1]); //이동하기전좌표를지움

			printf(" ");
			S[0][1] = y;
			S[0][2] = x;

			gotoxy(S[0][2], S[0][1]); //if문에 받은 x,y에 *을 지정
			textcolor(12);
			printf("@");

			if (E[y][x] == 1) //먹이를 먹었을때
			{

				Sspeed -= 1200000;

				Ecnt++;
				L = L + 1;  //꼬리를 늘려준다.

				jumsu += 10;
				textcolor(14);
				gotoxy(45, 1);
				printf("당신의 점수:%3d점", jumsu);

				E[y][x] = 0; //먹이는 지운다   

			}

		}
		/////////////적뱀  

		if (speed % S2speed == 0)
		{

			if (abs(x2 - x)<abs(y2 - y) && y<y2)y2 = y2 - 1;//위

			if (abs(x2 - x)<abs(y2 - y) && y>y2)y2 = y2 + 1;//아래

			if (abs(x2 - x)>abs(y2 - y) && x<x2)x2 = x2 - 1;//왼쪽

			if (abs(x2 - x)>abs(y2 - y) && x>x2)x2 = x2 + 1;//오른쪽


			for (i = 5; i >= 0; i--)
			{
				S2[i + 1][1] = S2[i][1];
				S2[i + 1][2] = S2[i][2];
			}
			gotoxy(S2[5][2], S2[5][1]); //이동하기전좌표를지움 

			printf(" ");

			S2[0][1] = y2;

			S2[0][2] = x2;
			textcolor(9);
			gotoxy(S2[0][2], S2[0][1]); //if문에 받은 x,y에 *을 지정
			printf("*");
			if (E[y2][x2] == 1)
			{
				Ecnt++;
				jumsu1 += 10;
				textcolor(14);
				gotoxy(3, 1);
				E[y2][x2] = 0;
				printf("적뱀의 점수:%3d점", jumsu1);

			}
			for (i = 0; i<L; i++)   //적 뱀이 몸에 닿았을 경우
			{
				if (S[i][1] == y2 && S[i][2] == x2)
				{
					for (i = 5; i >= 0; i--)    //적뱀의 현재 위치를 지움
					{
						gotoxy(S2[i][2], S2[i][1]);
						printf(" ");
					}
					x2 = 3, y2 = 4;  //적 뱀 시작점으로 이동
					S2[0][1] = y2;
					S2[0][2] = x2;
					gotoxy(x2, y2);
					textcolor(9);
					printf("*");
					life += 1;
					textcolor(15);
					gotoxy(75 + life, 1);
					printf("X");
				}

				if (life == 3 || Ecnt == 10)
				{

					while (!_kbhit())
					{
						Sleep(30);
						gotoxy(28, 15);
						test = rand() % 15;
						textcolor(test);
						printf("프로그래머");
						textcolor(13);
						gotoxy(24, 17);
						printf("Enter를 누르면 게임이 종료됩니다");
					}
					return 0;
				}
			}

		}
	}

	system("pause");

	return 0;

}