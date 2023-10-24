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


void textcolor(int color_number)                    
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color_number);
}

int main()
{
	srand(time(NULL));
	int i,ex,ey,y,x,zx=0,y1,x1,E[30][100]={0},jumsu=0; //변수선언 추가하기
	y=10;       
	x=40;       

	//////////////////////////////////////////////// 점수 표시구간
	textcolor(10);
	gotoxy(1,2);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
	gotoxy(1,24);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	textcolor(14);
	gotoxy(45,1);
	printf("당신의 점수:%3d점",jumsu);
	///////////////////////////////////////////////
	
	for (i = 1; i <= 10; i++)
	{
		ey = rand() % 21 + 3;
		ex = rand() % 76 + 4;
		E[ey][ex]=1;         
		textcolor(2);        
		gotoxy(ex, ey);      
		printf("$");         
	}
	

	while(1)    
	{
		Sleep(100);
		y1=y;   
		x1=x;  
		if(_kbhit()){zx=_getch();}
		if(zx==119)y=y-1;
		if(zx==115)y=y+1;
		if(zx==97)x=x-1;
		if(zx==100)x=x+1;
		if(zx==27)break;
		
		if(x==80)x=2;               
		if(x==1)x=79;              
		if(y==24)y=3;               
		if(y==2)y=23;              
		
		/////////////////////////////////////////////////////////
		if(E[y][x]==1)                    //먹이를 먹었을때
		{	
			jumsu+=10;                    //점수를 10점 더하기
			textcolor(14);
			gotoxy(45,1);                 //45, 1위치에 점수를 출력
			printf("당신의 점수:%3d점",jumsu);
			E[y][x]=0;                    //먹이는 지운다   
		}
		/////////////////////////////////////////////////////////
		
		gotoxy(x1,y1);     		
		printf(" ");       
		textcolor(13);   
		gotoxy(x,y);                                                       
		printf("*");    


	}
	system("pause");
	return 0;
}
