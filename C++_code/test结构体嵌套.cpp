#include<stdio.h>
#include<stdlib.h>
typedef struct author {
	char name[20];
	int age;
}author, *_author;

typedef struct book {
	char book_name[20];
	author aur;
	int price;
}book, *_book;

int main() {
	//_author no2 = &no1;
	book book1 = {"Jian", {"ANGUS", 20}, 55};
	_book book2 = &book1;
	printf("书名: %s, 作者名字：%s, 作者年龄：%d, 书本价格: %d\n", book1.book_name,book1.aur.name, book1.aur.age, book1.price);
	printf("书名: %s, 作者名字：%s, 作者年龄：%d, 书本价格: %d\n", book2->book_name,book2->aur.name, book2->aur.age, book2->price);
	return 0;
}
