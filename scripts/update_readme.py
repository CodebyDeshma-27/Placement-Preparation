import re
from pathlib import Path

README = Path("SQL/README.md")

leetcode_count = 0
hackerrank_count = 0

# Count LeetCode questions
leetcode_dir = Path("SQL/LeetCode")

for file in leetcode_dir.glob("*.md"):
    content = file.read_text(encoding="utf-8")
    leetcode_count += len(re.findall(r"Q\d+\.", content))

# Count HackerRank questions
hackerrank_dir = Path("SQL/HackerRank")

for file in hackerrank_dir.glob("*.md"):
    content = file.read_text(encoding="utf-8")

    hackerrank_count += (
        content.count("The PADS")
        + content.count("Print Prime Numbers")
        + content.count("Draw The Triangle")
        + content.count("Weather Observation")
        + content.count("The Blunder")
        + content.count("Type of Triangle")
    )

total = leetcode_count + hackerrank_count

# Progress bars
leetcode_goal = 50
hackerrank_goal = 46

def progress_bar(current, goal):
    filled = int((current / goal) * 20)
    return "█" * filled + "░" * (20 - filled)

leetcode_bar = progress_bar(leetcode_count, leetcode_goal)
hackerrank_bar = progress_bar(hackerrank_count, hackerrank_goal)

content = README.read_text(encoding="utf-8")

content = re.sub(
    r"<!-- LEETCODE -->.*?<!-- END_LEETCODE -->",
    f"<!-- LEETCODE -->{leetcode_count}<!-- END_LEETCODE -->",
    content,
    flags=re.S,
)

content = re.sub(
    r"<!-- HACKERRANK -->.*?<!-- END_HACKERRANK -->",
    f"<!-- HACKERRANK -->{hackerrank_count}<!-- END_HACKERRANK -->",
    content,
    flags=re.S,
)

content = re.sub(
    r"<!-- TOTAL -->.*?<!-- END_TOTAL -->",
    f"<!-- TOTAL -->{total}<!-- END_TOTAL -->",
    content,
    flags=re.S,
)

content = re.sub(
    r"<!-- LEETCODE_BAR -->.*?<!-- END_LEETCODE_BAR -->",
    f"<!-- LEETCODE_BAR -->\n{leetcode_bar}\n<!-- END_LEETCODE_BAR -->",
    content,
    flags=re.S,
)

content = re.sub(
    r"<!-- HACKERRANK_BAR -->.*?<!-- END_HACKERRANK_BAR -->",
    f"<!-- HACKERRANK_BAR -->\n{hackerrank_bar}\n<!-- END_HACKERRANK_BAR -->",
    content,
    flags=re.S,
)

README.write_text(content, encoding="utf-8")

print("README updated successfully.")