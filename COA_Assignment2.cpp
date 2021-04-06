// COA_Assignment2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <iomanip>
#include <String>
using std::setw;

void DecimalToBinary(int n) {
	int binaryNumber[100], num = n;
	int i = 0;
	while (n > 0) {
		binaryNumber[i] = n % 2;
		n = n / 2;
		i++;
	}
	
	for (int j = i - 1; j >= 0; j--)
		std::cout << binaryNumber[j];
	std::cout << std::endl;
}
void DecimalToHexadecimal(int num) {
	char arr[100];
	int i = 0;
	while (num != 0) {
		int temp = 0;
		temp = num % 16;
		if (temp < 10) {
			arr[i] = temp + 48;
			i++;
		}
		else {
			arr[i] = temp + 55;
			i++;
		}
		num = num / 16;
	}
	for (int j = i - 1; j >= 0; j--)
		std::cout << arr[j];
}
int main() {
	int choice;
	int val;
	int response;
	do {
		
		std::cout << "Welcome to Wale Wase converter." << std::endl;
		std::cout << "If you wish to convert one value, press 1." << std::endl;
		std::cout << "If you wish to convert multiple values, press 2." << std::endl;
		std::cin >> choice;
		if (choice == 1) {

			std::cout << "Input the value you would like to convert." << std::endl;
			std::cin >> val;
			std::cout << "-------------------------------------" << std::endl;

			std::cout << setw(10) << "Decimal";
			std::cout << setw(21) << "Binary";
			std::cout << setw(21) << "Hexadecimal" << std::endl;
			std::cout << "-------------------------------------" << std::endl;
			std::cout << setw(10) << val;
			std::cout << setw(21);
			DecimalToBinary(val);
			std::cout << setw(21);
			DecimalToHexadecimal(val);


		}
		else if (choice == 2) {
			std::cout << "Input the number of values you would like to convert." << std::endl;
			int c;
			std::cin >> c;
			std::cout << "Input the values you would like to convert." << std::endl;
			int arr[100];
			for (int i = 0;i < c;i++) {
				std::cin >> arr[i];
			}
			std::cout << "------------------------------------------------------------------------" << std::endl;

			std::cout << setw(10) << "Decimal";
			std::cout << setw(21) << "Binary";
			std::cout << setw(21) << "Hexadecimal" << std::endl;
			std::cout << "-------------------------------------------------------------------------" << std::endl;
			for (int i = 0;i < c;i++) {
				std::cout << arr[i] << std::setw(21);
				DecimalToBinary(arr[i]); std::setw(21);
					DecimalToHexadecimal(arr[i]);
				std::cout << std::endl;
			}


		}
		else {
			std::cout << "Wrong choice! Try Again";
		}
		std:: cout<< std::endl;
		std::cout << "Would you like to use the converter again? Respond with 1 for Yes or 2 for No" << std::endl;
		std::cin >> response;
	}
		while (response == 1);
	

	
	return 0;
}