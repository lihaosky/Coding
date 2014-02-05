#include <iostream>
#include <set>
#include <string>
#include <fstream>

using namespace std;

void solve(string filename) {
	set<string> allwords;
	string line;
	ifstream file;
	string longest = "";
	string  seclongest = "";
	int longest_len = -1;
	int count = 0;
	set<string>::iterator it;

	file.open(filename.c_str(), ifstream::in);
	if (!file.is_open()) {
		cerr << "Can't open file " << filename << endl;
		exit(-1);
	}

	// Insert all the words into set
	while (getline(file, line)) {
		// Avoid blank line
		if (line != "") {
			allwords.insert(line);
		}
	}
	file.close();

	// Iterate the set to find longest, second longest and total number
	for (it = allwords.begin(); it != allwords.end(); it++) {
		string word = *it;
		int len = word.length();
		bool *isexist = new bool[len + 1]; // isexist[i] represents whether substr(0, i) could be formed be shorter words

		memset(isexist, false, len + 1);
		isexist[0] = true; // Length 0 substing can be formed

		// Use dynamic programming to decide whether length up to i can be formed
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j <= i; j++) {
				string substr = word.substr(j, i - j + 1);
				if (isexist[j] && allwords.find(substr) != allwords.end()) {
					isexist[i + 1] = true;
					break;
				}
			}
		}

		// Separate case for last character to avoid word per se
		for (int j = 1; j < len; j++) {
			string substr = word.substr(j, len - j);
			if (isexist[j] && allwords.find(substr) != allwords.end()) {
				isexist[len] = true;
				break;
			}
		}

		// Can be formed
		if (isexist[len]) {
			count++;
			if (len > longest_len) {
				seclongest = longest;
				longest = word;
				longest_len = len;
			}
		}
		delete[] isexist;
	}

	cout << "Longest word is " << longest << endl;
	cout << "Second longest word is " << seclongest << endl;
	cout << "Total can be formed is " << count << endl;
}

int main() {
	solve("wordsforproblem.txt");
	return 0;
}
