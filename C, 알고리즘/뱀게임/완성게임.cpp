#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void gotoxy(int x, int y)
{

	COORD pos = { x - 1, y - 1 };//Ŀ���� X��ǥ���� -1 �Ѱ�. Y��ǥ���� -1�� ������ �̵�

	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);// WIN32API �Լ�

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

	int i, ey = 0, ex = 0, start = 0, L = 3; //L�� ���� ����

	int speed = 1;

	int test;


	while (!_kbhit())
	{
		Sleep(30);

		gotoxy(28, 15);
		test = rand() % 15;
		textcolor(test);
		printf("���α׷���");
		textcolor(13);
		gotoxy(24, 17);
		printf("Enter�� ������ ������ ���۵˴ϴ�!");
	}
	system("cls");
	textcolor(10);
	gotoxy(1, 2);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	gotoxy(1, 24);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	textcolor(14);
	gotoxy(45, 1);
	printf("����� ����:%3d��", jumsu);
	textcolor(14);
	gotoxy(3, 1);
	printf("������ ����:%3d��", jumsu1);
	gotoxy(69, 1);
	printf("��� : ");

	y = 20;
	x = 70;

	for (i = 1; i <= 10; i = i + 1)
	{
		ey = rand() % 21 + 3;
		ex = rand() % 76 + 4;
		E[ey][ex] = 1;//���� �迭�� ǥ��
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

			if (zx == 119)y = y - 1;//��

			if (zx == 115)y = y + 1;//�Ʒ�

			if (zx == 97)x = x - 1;//����

			if (zx == 100)x = x + 1;//������

			if (zx == 27)break; //ESC

								///////////////////////////////

			if (x == 80)x = 2;               //�������

			if (x == 1)x = 79;

			if (y == 24)y = 3;

			if (y == 2)y = 23;

			//////////////////////////////

			for (i = L - 1; i >= 0; i--)
			{
				S[i + 1][1] = S[i][1];

				S[i + 1][2] = S[i][2];
			}

			gotoxy(S[L][2], S[L][1]); //�̵��ϱ�����ǥ������

			printf(" ");
			S[0][1] = y;
			S[0][2] = x;

			gotoxy(S[0][2], S[0][1]); //if���� ���� x,y�� *�� ����
			textcolor(12);
			printf("@");

			if (E[y][x] == 1) //���̸� �Ծ�����
			{

				Sspeed -= 1200000;

				Ecnt++;
				L = L + 1;  //������ �÷��ش�.

				jumsu += 10;
				textcolor(14);
				gotoxy(45, 1);
				printf("����� ����:%3d��", jumsu);

				E[y][x] = 0; //���̴� �����   

			}

		}
		/////////////����  

		if (speed % S2speed == 0)
		{

			if (abs(x2 - x)<abs(y2 - y) && y<y2)y2 = y2 - 1;//��

			if (abs(x2 - x)<abs(y2 - y) && y>y2)y2 = y2 + 1;//�Ʒ�

			if (abs(x2 - x)>abs(y2 - y) && x<x2)x2 = x2 - 1;//����

			if (abs(x2 - x)>abs(y2 - y) && x>x2)x2 = x2 + 1;//������


			for (i = 5; i >= 0; i--)
			{
				S2[i + 1][1] = S2[i][1];
				S2[i + 1][2] = S2[i][2];
			}
			gotoxy(S2[5][2], S2[5][1]); //�̵��ϱ�����ǥ������ 

			printf(" ");

			S2[0][1] = y2;

			S2[0][2] = x2;
			textcolor(9);
			gotoxy(S2[0][2], S2[0][1]); //if���� ���� x,y�� *�� ����
			printf("*");
			if (E[y2][x2] == 1)
			{
				Ecnt++;
				jumsu1 += 10;
				textcolor(14);
				gotoxy(3, 1);
				E[y2][x2] = 0;
				printf("������ ����:%3d��", jumsu1);

			}
			for (i = 0; i<L; i++)   //�� ���� ���� ����� ���
			{
				if (S[i][1] == y2 && S[i][2] == x2)
				{
					for (i = 5; i >= 0; i--)    //������ ���� ��ġ�� ����
					{
						gotoxy(S2[i][2], S2[i][1]);
						printf(" ");
					}
					x2 = 3, y2 = 4;  //�� �� ���������� �̵�
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
						printf("���α׷���");
						textcolor(13);
						gotoxy(24, 17);
						printf("Enter�� ������ ������ ����˴ϴ�");
					}
					return 0;
				}
			}

		}
	}

	system("pause");

	return 0;

}