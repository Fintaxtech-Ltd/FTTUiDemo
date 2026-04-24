# ftt-ui-lib/SKILLS.md

Skills for the main FTT Android UI library module.

---

## Skill: Create Reusable Compose Component

Use when adding a new public UI component.

### Inputs

```markdown
component = "Button"        # e.g. Button, TextField, Card, Toolbar
prefix = "FTT"
package = "uk.co.fintaxtech.ui"
```

### Generate

- `${prefix}${component}.kt`
- Preview(s)
- Tests if interactive
- Optional demo usage if requested

### Rules

- Component name must use FTT prefix when public:
  - `FTTButton`
  - `FTTTextField`
  - `FTTCard`
- Use `@Composable`.
- Prefer stateless APIs.
- Expose `modifier: Modifier = Modifier`.
- Support `enabled`, loading, error, or selected states only when relevant.
- Use FTT theme tokens.
- Do not hardcode app/business strings.
- Add KDoc for public components when API is not obvious.
- Do not use wildcard imports.

### Output Format for AI

- One file per code block.
- Start with:
  `// FILE: ftt-ui-lib/src/main/java/.../<FileName>.kt`

---

## Skill: Create Component Preview

Use when creating or updating previews.

### Rules

- Preview names end with `Preview`.
- Wrap with `FTTTheme`.
- Include light/dark variants when visual differences matter.
- Do not use production-only dependencies.
- Keep sample data private.

---

## Skill: Create Design Token

Use when adding theme values.

### Generate

Possible files depending on token:

- `FTTColors.kt`
- `FTTTypography.kt`
- `FTTSpacing.kt`
- `FTTShape.kt`

### Rules

- Tokens must be reusable and not screen-specific.
- Do not scatter raw colors/dimensions inside components.
- Add preview/demo if visual.

---

## Skill: Add Compose UI Test

Use for interactive components.

### Rules

- Use Compose test APIs.
- Prefer assertions based on semantics.
- Test names use `action_condition_expectedResult`.
- Use explicit imports only.
- Do not test Material internals; test this library's contract.

Example names:

- `click_enabledButton_invokesOnClick()`
- `render_disabledButton_hasDisabledSemantics()`
- `typeText_validInput_updatesValue()`

---

## Skill: Prepare Library Release

Use when preparing a new Maven package version.

### Checklist

- Update version in publishing config.
- Confirm artifact coordinates remain:
  - `uk.co.fintaxtech:ftt-android-ui-lib`
- Run:
  - `./gradlew :ftt-ui-lib:assembleRelease`
  - `./gradlew :ftt-ui-lib:test`
- Confirm demo still builds:
  - `./gradlew :feature-demo:assembleDebug`
- Update README usage if API changed.
- Add changelog notes.
