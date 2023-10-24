#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void gotoxy(int x, int y)
{
	COORD pos = { x - 1, y - 1 };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

int main()
{
	int y, x, zx = 0, y1, x1;
	y = 10;
	x = 40;

	while (1)
	{
		Sleep(100);
		y1 = y;
		x1 = x;
		if (_kbhit()) { zx = _getch(); }		/// 키에서 입력 받을때만 zx에 키값 넣주기
		if (zx == 119)y = y - 1;
		if (zx == 115)y = y + 1;
		if (zx == 97)x = x - 1;
		if (zx == 100)x = x + 1;
		if (zx == 27)break;

		//////////////////////////////
		if (x == 80)x = 2;
		if (x == 1)x = 79;
		if (y == 24)y = 3;
		if (y == 2)y = 23;
		//////////////////////////////

		gotoxy(x1, y1);
		printf(" ");
		gotoxy(x, y);
		printf("@");
	}
	system("pause");
	return 0;
}
