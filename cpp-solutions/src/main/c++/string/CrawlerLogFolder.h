//
// Created by fedorenko on 14.10.2022.
//

#ifndef C_ALGORITMS_CRAWLERLOGFOLDER_H
#define C_ALGORITMS_CRAWLERLOGFOLDER_H

#include <string>
#include <vector>

using namespace std;


class CrawlerLogFolder {

public:
    int minOperations(vector<string> &logs) {
        int level = 0;

        for (const string &log: logs) {
            if (log == "../") {
                if (level > 0)
                    level--;
            }

            else if (log != "./")
                level++;
        }

        return level;
    }
};


#endif //C_ALGORITMS_CRAWLERLOGFOLDER_H
