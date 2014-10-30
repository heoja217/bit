/*
 ============================================================================
 Name        : ctest01.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
/*

	int i =20;
	float f = 3.14f;
	int* p = &f;
	*p = 30;

	printf("i = %d\n", i);
	printf("i의 주소 = %x\n", p);
*/

/*
	int scores[5];

	scores[0] = 100;
	scores[1] = 90;
	scores[2] = 80;
	scores[3] = 70;
	scores[4] = 60;

	int i;

	for (i = 0; i < 5; i++) {
		printf("%d =>%d\n", i, scores[i]);
	*/

	int scores[5];
	// int* p = &scores[0];
	int* p = scores;
/*

	*p = 100;
	*(p + 1) = 90;
	*(p + 2) = 80;
	*(p + 3) = 70;
	*(p + 4) = 60;
*/
	p[0] = 100;
	p[1] = 90;
	p[2] = 80;
	p[3] = 70;
	p[4] = 60;

	int i;

	for (i = 0; i < 5; i++) {
		printf(";;%x =>%d\n", (p+i), *(p+i));
	}



}
