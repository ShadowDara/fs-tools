-- Lua Runner
-- https://github.com/ShadowDara/LuaAPI-Rust

-- Copy File
local function copy_file(source, dest)
    local infile = io.open(source, "rb")
    if not infile then return false, "Kann Quelldatei nicht öffnen." end

    local content = infile:read("*all")
    infile:close()

    local outfile = io.open(dest, "wb")
    if not outfile then return false, "Kann Zieldatei nicht erstellen." end

    outfile:write(content)
    outfile:close()
    return true
end

-- Using
local ok, err = copy_file("Readme.txt", "src/main/resources/Readme.txt")
if ok then
    print("File moved succesfully!")
else
    print("Error: " .. err)
end

local ok, err = copy_file("LICENSE", "src/main/resources/LICENSE")
if ok then
    print("File moved succesfully!")
else
    print("Error: " .. err)
end
