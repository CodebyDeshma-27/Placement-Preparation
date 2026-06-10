import os
import json
from datetime import datetime

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

TRACKED_FOLDERS = [
    "SQL",
    "DSA",
    "DBMS",
    "OS",
    "CN",
    "OOP"
]

stats = {}
total = 0

for folder in TRACKED_FOLDERS:
    path = os.path.join(ROOT, folder)

    count = 0

    if os.path.exists(path):
        for root, dirs, files in os.walk(path):
            for file in files:

                if file.lower() == "readme.md":
                    continue

                if file.startswith("."):
                    continue

                count += 1

    stats[folder] = count
    total += count

data = {
    "last_updated": datetime.now().strftime("%Y-%m-%d %H:%M"),
    "total_problems": total,
    "subjects": stats
}

with open(
    os.path.join(ROOT, "progress_data.json"),
    "w",
    encoding="utf-8"
) as f:
    json.dump(data, f, indent=4)

print("Progress updated!")